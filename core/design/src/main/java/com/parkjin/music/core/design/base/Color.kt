package com.parkjin.music.core.design.base

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val LocalColorScheme = staticCompositionLocalOf { ColorScheme }

object ColorScheme {
    val primary = Color(0xFFE63E43)
    val content = Color(0xFF868686)
    val content999 = Color(0xFFFFFFFF)
    val background = Color(0xFFFFFFFF)
}
