package com.tizzone.albumapp.domain.model.mappers

import com.tizzone.albumapp.data.network.model.AlbumDtoModel
import com.tizzone.albumapp.domain.model.Track

class AlbumDtoMapper : ApiMapper<AlbumDtoModel, Track> {
    override fun mapToDomainModel(itemDto: AlbumDtoModel): Track {
        return Track(
            id = itemDto.id!!,
            title = itemDto.title!!,
            url = itemDto.url!!,
            thumbnailUrl = itemDto.thumbnailUrl!!
        )
    }
    fun toDomainAlbumsList(initial: List<AlbumDtoModel>): List<Track> {
        return initial.map { mapToDomainModel(it) }
    }
}
