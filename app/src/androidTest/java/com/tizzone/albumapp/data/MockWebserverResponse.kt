package com.tizzone.albumapp.data

import com.tizzone.albumapp.domain.model.Track

object MockWebserverResponse {
    val mockTrackList = listOf<Track>(
        Track(
            "10",
            "delectus",
            "\"https://via.placeholder.com/600/d6dd28",
            "https://via.placeholder.com/600/d6dd28",
        ),
        Track(
            "11",
            "deserunt",
            "\"https://via.placeholder.com/600/d6dd28",
            "https://via.placeholder.com/600/d6dd28",
        ),
        Track(
            "12",
            "quidem",
            "https://via.placeholder.com/600/d6dd28",
            "https://via.placeholder.com/600/d6dd28",
        )
    )
}
