package com.parkjin.music.core.design.component.text

import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.parkjin.music.core.design.base.AppleMusicTheme
import com.parkjin.music.core.design.base.LocalColorScheme
import com.parkjin.music.core.design.base.LocalTypography

@Composable
fun Text(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = LocalTypography.current.body3,
    color: Color = LocalColorScheme.current.content,
    overflow: TextOverflow = TextOverflow.Ellipsis,
) {
    BasicText(
        modifier = modifier,
        text = text,
        style = style.copy(
            color = color,
        ),
        overflow = overflow,
    )
}

@Preview
@Composable
fun TextPreview() {
    AppleMusicTheme {
        Text(text = "Preview")
    }
}
