package com.tizzone.albumapp.domain.repositories

import com.tizzone.albumapp.data.network.AlbumsApi
import com.tizzone.albumapp.domain.data.TrackViewState
import com.tizzone.albumapp.domain.model.mappers.AlbumDtoMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

sealed interface AlbumsRepository {
    suspend fun getAsyncAllAlbums(): Flow<TrackViewState>
}

class AlbumsRepositoryImpl @Inject constructor(
    private val albumsApi: AlbumsApi,
    private val mapper: AlbumDtoMapper
) : AlbumsRepository {
    override suspend fun getAsyncAllAlbums(): Flow<TrackViewState> = flow {
        try {
            emit(TrackViewState(isLoading = true))
            val albumsTitlesList = mapper.toDomainAlbumsList(albumsApi.getAsyncAlbums())
            emit(TrackViewState(data = albumsTitlesList))
        } catch (e: Exception) {
            emit(TrackViewState(message = e.message ?: "Unknown error"))
        }
    }
}
