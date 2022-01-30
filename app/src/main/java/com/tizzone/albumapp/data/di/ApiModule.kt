package com.tizzone.albumapp.data.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.tizzone.albumapp.BuildConfig
import com.tizzone.albumapp.data.network.AlbumsApi
import com.tizzone.albumapp.domain.model.mappers.AlbumDtoMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ApiModule {
    @Provides
    @Singleton
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else {
        OkHttpClient
            .Builder()
            .build()
    }

    @Provides
    @Singleton
    fun providesApi(okHttpClient: OkHttpClient, BASE_URL: String): AlbumsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(okHttpClient)
            .build()
            .create(AlbumsApi::class.java)
    }

    @Provides
    @Singleton
    fun providesAlbumDtoMapper(): AlbumDtoMapper {
        return AlbumDtoMapper()
    }
}
