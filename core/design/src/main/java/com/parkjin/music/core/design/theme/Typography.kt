package com.parkjin.music.core.design.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp
import com.parkjin.music.core.design.R

val LocalTypography = staticCompositionLocalOf { Typography }

object Typography {

    private val fontFamily = FontFamily(
        Font(R.font.pretendard_bold, FontWeight.Bold),
        Font(R.font.pretendard_semibold, FontWeight.SemiBold),
        Font(R.font.pretendard_medium, FontWeight.Medium),
        Font(R.font.pretendard_regular, FontWeight.Normal),
    )

    @Suppress("DEPRECATION")
    private val platformTextStyle = PlatformTextStyle(false)

    val heading3 = TextStyle(
        fontSize = 32.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        platformStyle = platformTextStyle,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None,
        ),
    )

    val heading4 = TextStyle(
        fontSize = 28.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        platformStyle = platformTextStyle,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None,
        ),
    )

    val heading5 = TextStyle(
        fontSize = 24.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        platformStyle = platformTextStyle,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None,
        ),
    )

    val heading6 = TextStyle(
        fontSize = 20.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        platformStyle = platformTextStyle,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None,
        ),
    )

    val body1 = TextStyle(
        fontSize = 18.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        platformStyle = platformTextStyle,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None,
        ),
    )

    val body2 = TextStyle(
        fontSize = 16.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        platformStyle = platformTextStyle,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None,
        ),
    )

    val body3 = TextStyle(
        fontSize = 14.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        platformStyle = platformTextStyle,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None,
        ),
    )

    val caption1 = TextStyle(
        fontSize = 12.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        platformStyle = platformTextStyle,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None,
        ),
    )

    val caption2 = TextStyle(
        fontSize = 10.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        platformStyle = platformTextStyle,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None,
        ),
    )

    val caption3 = TextStyle(
        fontSize = 8.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal,
        platformStyle = platformTextStyle,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None,
        ),
    )
}
