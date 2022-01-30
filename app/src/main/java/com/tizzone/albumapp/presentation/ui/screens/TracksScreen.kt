package com.tizzone.albumapp.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tizzone.albumapp.R
import com.tizzone.albumapp.presentation.presentation.Screen
import com.tizzone.albumapp.presentation.ui.TracksViewModel
import com.tizzone.albumapp.presentation.ui.components.MyTopAppBar
import com.tizzone.albumapp.presentation.ui.components.TrackCard
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TracksScreen(
    viewModel: TracksViewModel,
    onNavigateToTrackDetail: (String) -> Unit
) {
    val state = viewModel.state.collectAsState().value
    if (state.isLoading) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(50.dp)
            )
            Text(
                modifier = Modifier.padding(8.dp),
                text = stringResource(id = R.string.wait)
            )
        }
    } else if (state.data.isNotEmpty()) {
        Scaffold(
            topBar = {
                MyTopAppBar(R.string.tracks)
            },
            containerColor = MaterialTheme.colorScheme.surface,
            modifier = Modifier.padding(bottom = 5.dp)
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
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.padding(30.dp),
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                text = stringResource(R.string.default_error_message)
            )
        }
    }
}
