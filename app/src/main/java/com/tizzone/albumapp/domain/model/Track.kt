package com.tizzone.albumapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Track(
    val id: String,
    val title: String,
    val url: String,
    val thumbnailUrl: String,
) : Parcelable
