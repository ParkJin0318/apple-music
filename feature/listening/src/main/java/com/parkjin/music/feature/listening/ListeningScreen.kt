package com.parkjin.music.feature.listening

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.parkjin.music.core.design.theme.LocalColorScheme
import com.parkjin.music.core.design.theme.LocalTypography
import com.parkjin.music.core.design.component.track.TrackCard
import com.parkjin.music.core.design.element.text.Text
import com.parkjin.music.feature.listening.extension.onBottomReached

@Composable
fun ListeningScreen(
    modifier: Modifier = Modifier,
    viewModel: ListeningViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    val listState = rememberLazyListState()

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = LocalColorScheme.current.background),
        state = listState,
    ) {
        items(state.sections, key = { it.id }) { section ->
            when (section) {
                is ListeningUISection.Header -> {
                    Text(
                        modifier = Modifier
                            .padding(start = 20.dp, top = 40.dp, bottom = 12.dp, end = 20.dp),
                        text = stringResource(id = R.string.listening_screen_title),
                        style = LocalTypography.current.heading3.copy(
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                }

                is ListeningUISection.Loading -> {
                    Text(
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(vertical = 20.dp),
                        text = stringResource(id = R.string.listening_screen_loading),
                        color = LocalColorScheme.current.content200,
                        style = LocalTypography.current.body3.copy(
                            textAlign = TextAlign.Center,
                        ),
                    )
                }

                is ListeningUISection.TrackItem -> {
                    val track = section.track

                    TrackCard(
                        modifier = Modifier.fillMaxWidth(),
                        trackName = track.trackName,
                        albumName = track.collectionName,
                        artistName = track.artistName,
                        artworkUrl = track.artworkUrl,
                        isArchived = track.isArchived,
                        onClickArchive = { isArchive ->
                            if (isArchive) {
                                viewModel.archiveTrack(track)
                            } else {
                                viewModel.unarchiveTrack(track)
                            }
                        },
                    )
                }
            }
        }
    }

    listState.onBottomReached(threshold = 1) {
        viewModel.loadTracks()
    }
}
