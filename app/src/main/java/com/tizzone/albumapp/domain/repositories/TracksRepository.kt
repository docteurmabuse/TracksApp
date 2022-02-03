package com.tizzone.albumapp.domain.repositories

import com.tizzone.albumapp.data.network.TracksApi
import com.tizzone.albumapp.domain.data.TrackViewState
import com.tizzone.albumapp.domain.model.mappers.TrackDtoMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

sealed interface TracksRepository {
    suspend fun getAsyncAllAlbums(): Flow<TrackViewState>
}

class TracksRepositoryImpl @Inject constructor(
    private val tracksApi: TracksApi,
    private val mapper: TrackDtoMapper
) : TracksRepository {
    override suspend fun getAsyncAllAlbums(): Flow<TrackViewState> = flow {
        try {
            emit(TrackViewState(isLoading = true))
            val albumsTitlesList = mapper.toDomainAlbumsList(tracksApi.getAsyncAlbums())
            emit(TrackViewState(data = albumsTitlesList))
        } catch (e: HttpException) {
            emit(TrackViewState(message = e.message ?: "Unknown error"))
        } catch (e: IOException) {
            emit(TrackViewState(message = e.message ?: "No Internet error"))
        }
    }
}
