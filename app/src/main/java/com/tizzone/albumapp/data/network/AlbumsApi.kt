package com.tizzone.albumapp.data.network

import com.tizzone.albumapp.data.network.model.AlbumDtoModel
import retrofit2.http.GET

interface AlbumsApi {
    @GET("img/shared/technical-test.json")
    suspend fun getAsyncAlbums(): List<AlbumDtoModel>
}
