package com.parkjin.music.core.design.element.icon

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.toolingGraphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.parkjin.music.core.design.R
import com.parkjin.music.core.design.theme.AppleMusicTheme

@Composable
fun Icon(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    size: Dp,
    tint: Color? = null,
) {
    Icon(
        modifier = modifier,
        painter = rememberVectorPainter(image = imageVector),
        size = size,
        tint = tint,
    )
}

@Composable
fun Icon(
    modifier: Modifier = Modifier,
    painter: Painter,
    size: Dp,
    tint: Color? = null,
) {
    Box(
        modifier = modifier
            .toolingGraphicsLayer()
            .requiredSize(size)
            .paint(
                painter = painter,
                contentScale = ContentScale.Fit,
                colorFilter = tint?.let(ColorFilter::tint),
            ),
    )
}

@Preview
@Composable
fun IconPreview() {
    AppleMusicTheme {
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.icon_listening),
            size = 24.dp,
        )
    }
}
