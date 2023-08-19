package com.parkjin.music.feature.listening

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.parkjin.music.core.design.base.LocalColorScheme
import com.parkjin.music.core.design.base.LocalTypography
import com.parkjin.music.core.design.component.listening.TrackCard
import com.parkjin.music.core.design.component.text.Text

@Composable
fun ListeningScreen(
    modifier: Modifier = Modifier,
    viewModel: ListeningViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = LocalColorScheme.current.background),
    ) {
        val sections = mutableListOf<ListeningScreenSection>(ListeningScreenSection.Header)

        if (state.tracks.isEmpty()) {
            sections.add(ListeningScreenSection.Empty)
        } else {
            sections.addAll(state.tracks.map(ListeningScreenSection::TrackItem))
        }

        items(sections, key = { it.id }) { section ->
            when (section) {
                is ListeningScreenSection.Header -> {
                    Text(
                        modifier = Modifier
                            .padding(start = 20.dp, top = 40.dp, bottom = 12.dp, end = 20.dp),
                        text = stringResource(id = R.string.listening_screen_title),
                        style = LocalTypography.current.heading3.copy(
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                }

                is ListeningScreenSection.Empty -> {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 120.dp, start = 48.dp, end = 48.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = stringResource(id = R.string.listening_screen_empty_title),
                            style = LocalTypography.current.heading6.copy(
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Center,
                            ),
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = stringResource(id = R.string.listening_screen_empty_subtitle),
                            style = LocalTypography.current.body3.copy(
                                color = LocalColorScheme.current.content,
                                textAlign = TextAlign.Center,
                            ),
                        )
                    }
                }

                is ListeningScreenSection.TrackItem -> {
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
}
