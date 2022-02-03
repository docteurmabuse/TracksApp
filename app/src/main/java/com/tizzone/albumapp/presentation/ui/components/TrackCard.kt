package com.tizzone.albumapp.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.coil.CoilImage
import com.tizzone.albumapp.R
import com.tizzone.albumapp.domain.model.Track
import com.tizzone.albumapp.presentation.theme.TracksAppTheme

@Composable
fun TrackCard(
    track: Track,
    modifier: Modifier,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            // The space between each card and the other
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable(onClick = onClick),
        shape = MaterialTheme.shapes.medium,
        elevation = 8.dp,
        backgroundColor = MaterialTheme.colors.surface,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            CoilImage(
                imageModel = track.thumbnailUrl,
                // Crop, Fit, Inside, FillHeight, FillWidth, None
                contentScale = ContentScale.Crop,
                modifier = modifier.size(80.dp),
                // shows an image with a circular revealed animation.
                circularReveal = CircularReveal(duration = 250),
                // shows a placeholder ImageBitmap when loading.
                placeHolder = painterResource(id = R.drawable.ic_baseline_photo_album_24),
                // shows an error ImageBitmap when the request failed.
                error = painterResource(id = R.drawable.ic_baseline_photo_album_24),
            )
            Text(
                modifier = Modifier.padding(8.dp),
                text = track.title,
                style = androidx.compose.material3.MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun TrackCardPreview() {
    TracksAppTheme {
        TrackCard(
            track = Track(
                "10",
                "delectus",
                "https://via.placeholder.com/600/d6dd28",
                "https://via.placeholder.com/600/d6dd28",
            ),
            modifier = Modifier,
            onClick = {}
        )
    }
}
