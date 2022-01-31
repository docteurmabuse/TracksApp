package com.tizzone.albumapp.domain.usecases

import com.tizzone.albumapp.domain.repositories.TracksRepositoryImpl
import javax.inject.Inject

class GetTracks @Inject constructor(
    private val repository: TracksRepositoryImpl
) {
    suspend operator fun invoke() = repository.getAsyncAllAlbums()
}
