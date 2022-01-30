package com.tizzone.albumapp.data.network.model

import com.google.gson.annotations.SerializedName

data class AlbumDtoModel(
    @field:SerializedName("albumId")
    val albumId: String? = null,

    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("thumbnailUrl")
    val thumbnailUrl: String? = null
)
