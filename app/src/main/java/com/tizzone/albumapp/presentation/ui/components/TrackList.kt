package com.tizzone.albumapp.presentation.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tizzone.albumapp.domain.data.TrackViewState
import com.tizzone.albumapp.presentation.presentation.Screen
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun TrackList(
    state: TrackViewState,
    onNavigateToTrackDetail: (String) -> Unit
) {
    LazyColumn(
        Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(state.data) { track ->
            TrackCard(
                modifier = Modifier,
                track = track,
                onClick = {
                    val encodedUrl = URLEncoder.encode(track.url, StandardCharsets.UTF_8.toString())
                    val route = Screen.TrackDetail.route + "/${track.title}/$encodedUrl"
                    onNavigateToTrackDetail(route)
                }
            )
        }
    }
}
