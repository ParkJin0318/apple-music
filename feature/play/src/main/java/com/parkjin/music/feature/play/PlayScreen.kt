package com.parkjin.music.feature.play

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.parkjin.music.core.design.component.text.Text

@Composable
fun PlayScreen(
    modifier: Modifier = Modifier,
    viewModel: PlayViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
    ) {
        items(state.songs) { song ->
            Text(
                text = song.trackName,
            )
        }
    }
}
