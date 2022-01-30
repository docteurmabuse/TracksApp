package com.tizzone.albumapp.presentation.presentation

sealed class Screen(
    val route: String,
) {
    object TracksList : Screen("tracksList")
    object TrackDetail : Screen("trackDetail")
}
