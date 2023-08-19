package com.parkjin.music.feature.storage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.parkjin.music.core.design.base.LocalColorScheme
import com.parkjin.music.core.design.component.text.Text

@Composable
fun StorageScreen(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(LocalColorScheme.current.background),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = "Storage")
    }
}
