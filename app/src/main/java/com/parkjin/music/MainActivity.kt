package com.parkjin.music

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.parkjin.music.core.design.theme.AppleMusicTheme
import com.parkjin.music.ui.AppleMusicApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppleMusicTheme {
                AppleMusicApp()
            }
        }
    }
}
