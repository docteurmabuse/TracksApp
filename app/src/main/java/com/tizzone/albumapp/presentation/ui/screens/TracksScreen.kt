package com.tizzone.albumapp.presentation.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.tizzone.albumapp.R
import com.tizzone.albumapp.domain.model.Track
import com.tizzone.albumapp.presentation.ui.components.TrackCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TracksScreen(titleList: List<Track>) {
    Scaffold(
        topBar = {
            MyTopAppBar()
        },
        containerColor = MaterialTheme.colorScheme.surface,
        modifier = Modifier.padding(bottom = 5.dp)
    ) {
        LazyColumn(
            Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(titleList) { track ->
                TrackCard(
                    modifier = Modifier,
                    track = track
                )
            }
        }
    }
}

@Composable
fun MyTopAppBar() {
    TopAppBar(
        title = { Text(stringResource(id = R.string.tracks)) },
        backgroundColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary
    )
}
