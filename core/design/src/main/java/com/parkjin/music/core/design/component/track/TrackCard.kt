package com.parkjin.music.core.design.component.track

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.parkjin.music.core.design.R
import com.parkjin.music.core.design.theme.AppleMusicTheme
import com.parkjin.music.core.design.theme.LocalColorScheme
import com.parkjin.music.core.design.theme.LocalTypography
import com.parkjin.music.core.design.element.icon.Icon
import com.parkjin.music.core.design.element.text.Text

@Composable
fun TrackCard(
    modifier: Modifier = Modifier,
    trackName: String,
    albumName: String,
    artistName: String,
    artworkUrl: String,
    isArchived: Boolean,
    onClickArchive: (isArchive: Boolean) -> Unit,
) {
    Row(
        modifier = modifier
            .background(LocalColorScheme.current.background)
            .padding(horizontal = 20.dp, vertical = 8.dp),
    ) {
        AsyncImage(
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(4.dp)),
            model = ImageRequest.Builder(LocalContext.current)
                .data(artworkUrl)
                .build(),
            contentScale = ContentScale.Crop,
            contentDescription = "track image",
        )

        Column(
            modifier = Modifier.weight(1f)
                .padding(horizontal = 12.dp),
        ) {
            Text(
                text = trackName,
                style = LocalTypography.current.body2.copy(
                    fontWeight = FontWeight.SemiBold,
                ),
            )

            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = albumName,
                style = LocalTypography.current.body3,
            )

            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = artistName,
                color = LocalColorScheme.current.content200,
                style = LocalTypography.current.body3,
            )
        }

        TrackArchiveIcon(
            modifier = Modifier
                .clickable { onClickArchive(isArchived.not()) },
            isArchived = isArchived,
        )
    }
}

@Composable
internal fun TrackArchiveIcon(
    modifier: Modifier = Modifier,
    isArchived: Boolean,
) {
    val size = 20.dp

    Box(
        modifier = modifier.requiredSize(size),
        contentAlignment = Alignment.Center,
    ) {
        AnimatedVisibility(
            visible = isArchived.not(),
            enter = slideInVertically(),
            exit = fadeOut(),
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.icon_download),
                size = size,
            )
        }

        AnimatedVisibility(
            visible = isArchived,
            enter = slideInVertically(),
            exit = fadeOut(),
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.icon_remove),
                size = size,
            )
        }
    }
}

@Preview
@Composable
fun PreviewTrackCard() {
    AppleMusicTheme {
        TrackCard(
            trackName = "Track Name",
            albumName = "Album Name",
            artistName = "Artist Name",
            artworkUrl = "",
            isArchived = false,
            onClickArchive = {},
        )
    }
}
