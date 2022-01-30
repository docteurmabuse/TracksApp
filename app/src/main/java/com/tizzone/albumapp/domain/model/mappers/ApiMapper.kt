package com.tizzone.albumapp.domain.model.mappers

interface ApiMapper<E, D> {
    fun mapToDomainModel(itemDto: E): D
}
