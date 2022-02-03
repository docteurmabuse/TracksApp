package com.tizzone.albumapp.utils

import com.tizzone.albumapp.domain.model.Track

const val BASE_URL = "https://static.leboncoin.fr/"
const val TRACKS_VIEWMODEL = "TracksViewModel"
const val TRACK_TITLE_URL = "/{trackTitle}/{trackUrl}"
const val TRACK_TITLE = "trackTitle"
const val TRACK_URL = "trackUrl"

val fakeTrackList = listOf(
    Track(
        "10",
        "delectus",
        "https://via.placeholder.com/600/d6dd28",
        "https://via.placeholder.com/600/d6dd28",
    ),
    Track(
        "11",
        "deserunt",
        "https://via.placeholder.com/600/d6dd28",
        "https://via.placeholder.com/600/d6dd28",
    ),
    Track(
        "12",
        "quidem",
        "https://via.placeholder.com/600/d6dd28",
        "https://via.placeholder.com/600/d6dd28",
    )
)
