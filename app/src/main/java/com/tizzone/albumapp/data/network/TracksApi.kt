package com.tizzone.albumapp.data.network

import com.tizzone.albumapp.data.network.model.TrackDtoModel
import retrofit2.http.GET

interface TracksApi {
    @GET("img/shared/technical-test.json")
    suspend fun getAsyncAlbums(): List<TrackDtoModel>
}
