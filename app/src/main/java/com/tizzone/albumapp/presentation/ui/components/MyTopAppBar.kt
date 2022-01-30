package com.tizzone.albumapp.presentation.ui.components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.tizzone.albumapp.R

@Composable
fun MyTopAppBar() {
    TopAppBar(
        title = { Text(stringResource(id = R.string.tracks)) },
        backgroundColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary
    )
}
