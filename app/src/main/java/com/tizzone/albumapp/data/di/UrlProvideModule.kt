package com.tizzone.albumapp.data.di

import com.tizzone.albumapp.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object UrlProvideModule {
    @Provides
    fun provideBaseUrl() = BASE_URL
}
