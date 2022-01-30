package com.tizzone.albumapp.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.coil.CoilImage
import com.tizzone.albumapp.R
import com.tizzone.albumapp.presentation.theme.TracksAppTheme
import com.tizzone.albumapp.presentation.ui.components.MyTopAppBar
import timber.log.Timber

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrackDetails(
    // track: Track?
    trackTitle: String?,
    url: String?,
) {
    if (trackTitle == null) {
        Timber.d("ERROR")
    } else {
        TracksAppTheme {
            Scaffold(
                topBar = {
                    MyTopAppBar(R.string.track)
                },
                containerColor = MaterialTheme.colorScheme.surface,
                modifier = Modifier.padding(bottom = 5.dp)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    item {
                        CoilImage(
                            imageModel = url,
                            contentDescription = trackTitle,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(225.dp),
                            contentScale = ContentScale.Crop,
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 4.dp)
                            ) {
                                Text(
                                    text = trackTitle,
                                    Modifier
                                        .fillMaxWidth(0.85f)
                                        .wrapContentWidth(Alignment.Start),
                                    style = MaterialTheme.typography.titleMedium
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
