package com.parkjin.music.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

internal val LocalColorScheme = staticCompositionLocalOf { ColorScheme }

object ColorScheme {
    val primary = Color(0xFFE63E43)
    val default = Color(0xFF858585)
    val background = Color(0xFFFFFFFF)
}
