package com.tizzone.albumapp.domain.data

import androidx.compose.runtime.Immutable
import com.tizzone.albumapp.domain.model.Track

@Immutable
class TrackViewState(
    val isLoading: Boolean = false,
    val data: List<Track> = listOf(),
    val message: String? = null
)
