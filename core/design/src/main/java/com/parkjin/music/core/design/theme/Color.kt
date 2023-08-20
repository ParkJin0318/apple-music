package com.parkjin.music.core.design.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val LocalColorScheme = staticCompositionLocalOf<ColorScheme> { LightColorScheme }

sealed interface ColorScheme {
    val primary: Color
    val secondary: Color
    val content: Color
    val content200: Color
    val background: Color
    val divider: Color
}

object LightColorScheme : ColorScheme {
    override val primary = Color(0xFFFFFFFF)
    override val secondary = Color(0xFFE63E43)
    override val content = Color(0xFF000000)
    override val content200: Color = Color(0xFF868686)
    override val background = Color(0xFFFFFFFF)
    override val divider = Color(0xFFE8E7E0)
}

object DarkColorScheme : ColorScheme {
    override val primary = Color(0xFFFFFFFF)
    override val secondary = Color(0xFFE63E43)
    override val content = Color(0xFFFFFFFF)
    override val content200: Color = Color(0xFF868686)
    override val background = Color(0xFF000000)
    override val divider = Color(0xFF444443)
}
