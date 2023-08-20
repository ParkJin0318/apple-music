package com.parkjin.music.core.design.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.parkjin.music.core.design.base.AppleMusicTheme
import com.parkjin.music.core.design.base.LocalColorScheme
import com.parkjin.music.core.design.base.LocalTypography
import com.parkjin.music.core.design.component.text.Text

@Composable
fun Button(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .background(color = LocalColorScheme.current.secondary, RoundedCornerShape(8.dp))
            .clickable { onClick() },
        contentAlignment = Alignment.Center,
    ) {
        Text(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 12.dp),
            text = text,
            color = LocalColorScheme.current.primary,
            style = LocalTypography.current.body2.copy(
                fontWeight = FontWeight.SemiBold,
            ),
        )
    }
}

@Preview
@Composable
fun ButtonPreview() {
    AppleMusicTheme {
        Button(
            text = "Button",
            onClick = {},
        )
    }
}
