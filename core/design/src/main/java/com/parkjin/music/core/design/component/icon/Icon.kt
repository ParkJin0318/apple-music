package com.parkjin.music.core.design.component.icon

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.Dp

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
            .size(size)
            .paint(
                painter = painter,
                contentScale = ContentScale.Fit,
                colorFilter = tint?.let(ColorFilter::tint),
            ),
    )
}
