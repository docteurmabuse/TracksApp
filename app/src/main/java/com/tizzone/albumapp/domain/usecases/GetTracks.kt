package com.tizzone.albumapp.domain.usecases

import com.tizzone.albumapp.domain.repositories.AlbumsRepositoryImpl
import javax.inject.Inject

class GetTracks @Inject constructor(
    private val repository: AlbumsRepositoryImpl
) {
    suspend operator fun invoke() = repository.getAsyncAllAlbums()
}
