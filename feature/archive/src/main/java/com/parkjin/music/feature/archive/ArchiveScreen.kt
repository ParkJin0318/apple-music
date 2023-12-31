package com.parkjin.music.feature.archive

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
import com.parkjin.music.core.design.theme.LocalColorScheme
import com.parkjin.music.core.design.theme.LocalTypography
import com.parkjin.music.core.design.element.button.Button
import com.parkjin.music.core.design.component.track.TrackCard
import com.parkjin.music.core.design.element.text.Text

@Composable
fun ArchiveScreen(
    modifier: Modifier = Modifier,
    onClickEmpty: () -> Unit,
    viewModel: ArchiveViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = LocalColorScheme.current.background),
    ) {
        items(state.sections, key = { it.id }) { section ->
            when (section) {
                is ArchiveUISection.Header -> {
                    Text(
                        modifier = Modifier
                            .padding(start = 20.dp, top = 40.dp, bottom = 12.dp, end = 20.dp),
                        text = stringResource(id = R.string.archive_screen_title),
                        style = LocalTypography.current.heading3.copy(
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                }

                is ArchiveUISection.Empty -> {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 120.dp, start = 48.dp, end = 48.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = stringResource(id = R.string.archive_screen_empty_title),
                            style = LocalTypography.current.heading6.copy(
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Center,
                            ),
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = stringResource(id = R.string.archive_screen_empty_subtitle),
                            color = LocalColorScheme.current.content200,
                            style = LocalTypography.current.body3.copy(
                                textAlign = TextAlign.Center,
                            ),
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Button(
                            modifier = Modifier
                                .fillMaxWidth(),
                            text = stringResource(id = R.string.archive_screen_empty_button),
                            onClick = onClickEmpty,
                        )
                    }
                }

                is ArchiveUISection.TrackItem -> {
                    val track = section.track

                    TrackCard(
                        modifier = Modifier
                            .fillMaxWidth(),
                        trackName = track.trackName,
                        albumName = track.collectionName,
                        artistName = track.artistName,
                        artworkUrl = track.artworkUrl,
                        isArchived = track.isArchived,
                        onClickArchive = { viewModel.unarchiveTrack(track) },
                    )
                }
            }
        }
    }
}
