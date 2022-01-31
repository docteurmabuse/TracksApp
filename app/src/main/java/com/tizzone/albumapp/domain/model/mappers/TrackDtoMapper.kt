package com.tizzone.albumapp.domain.model.mappers

import com.tizzone.albumapp.data.network.model.TrackDtoModel
import com.tizzone.albumapp.domain.model.Track

class TrackDtoMapper : ApiMapper<TrackDtoModel, Track> {
    override fun mapToDomainModel(itemDto: TrackDtoModel): Track {
        return Track(
            id = itemDto.id!!,
            title = itemDto.title!!,
            url = itemDto.url!!,
            thumbnailUrl = itemDto.thumbnailUrl!!
        )
    }
    fun toDomainAlbumsList(initial: List<TrackDtoModel>): List<Track> {
        return initial.map { mapToDomainModel(it) }
    }
}
