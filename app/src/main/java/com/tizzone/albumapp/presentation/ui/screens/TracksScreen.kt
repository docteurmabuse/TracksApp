package com.tizzone.albumapp.presentation.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tizzone.albumapp.R
import com.tizzone.albumapp.presentation.ui.TracksViewModel
import com.tizzone.albumapp.presentation.ui.components.TrackList

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
        TrackList(
            state = state,
            onNavigateToTrackDetail = onNavigateToTrackDetail
        )
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
