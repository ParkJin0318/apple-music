package com.parkjin.music.core.design.component.listening

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.parkjin.music.core.design.R
import com.parkjin.music.core.design.base.LocalColorScheme
import com.parkjin.music.core.design.base.LocalTypography
import com.parkjin.music.core.design.component.icon.Icon
import com.parkjin.music.core.design.component.text.Text

@Composable
fun TrackCard(
    modifier: Modifier = Modifier,
    trackName: String,
    albumName: String,
    artistName: String,
    artworkUrl: String,
    addedToLocker: Boolean,
    onClickLocker: (addToLocker: Boolean) -> Unit,
) {
    Row(
        modifier = modifier.padding(horizontal = 20.dp, vertical = 8.dp),
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
                style = LocalTypography.current.body1.copy(
                    fontWeight = FontWeight.SemiBold,
                ),
            )

            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = albumName,
                style = LocalTypography.current.body2,
            )

            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = artistName,
                style = LocalTypography.current.body2.copy(
                    color = LocalColorScheme.current.content,
                ),
            )
        }

        TrackLockerIcon(
            modifier = Modifier
                .clickable { onClickLocker(addedToLocker.not()) },
            addedToLocker = addedToLocker,
        )
    }
}

@Composable
internal fun TrackLockerIcon(
    modifier: Modifier = Modifier,
    addedToLocker: Boolean,
) {
    val size = 24.dp

    Box(
        modifier = modifier.size(size),
        contentAlignment = Alignment.Center,
    ) {
        AnimatedVisibility(visible = addedToLocker.not()) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.icon_download),
                size = size,
            )
        }

        AnimatedVisibility(visible = addedToLocker) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.icon_remove),
                size = size,
            )
        }
    }
}
