package com.parkjin.music.feature.listening

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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
        items(state.uiModels) { uiModel ->
            when (uiModel) {
                is ListeningUIModel.Header -> {
                    Text(
                        modifier = Modifier
                            .padding(start = 20.dp, top = 40.dp, bottom = 12.dp, end = 20.dp),
                        text = stringResource(id = R.string.listening_screen_title),
                        style = LocalTypography.current.heading3.copy(
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                }

                is ListeningUIModel.Track -> {
                    val content = uiModel.item

                    TrackCard(
                        modifier = Modifier.fillMaxWidth(),
                        trackName = content.trackName,
                        albumName = content.collectionName,
                        artistName = content.artistName,
                        artworkUrl = content.artworkUrl,
                        addedToStorage = false,
                        onClickStorage = { addToStorage ->
                            if (addToStorage) {
                                viewModel.addToStorage(content)
                            } else {
                                viewModel.removeToStorage(content)
                            }
                        },
                    )
                }
            }
        }
    }
}
