package com.parkjin.music.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.parkjin.music.feature.listening.ListeningScreen
import com.parkjin.music.feature.archive.ArchiveScreen

@Composable
fun AppleMusicNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    Box(
        modifier = modifier,
    ) {
        NavHost(
            navController = navController,
            startDestination = AppleMusicNavigationType.Listening.route,
        ) {
            composable(AppleMusicNavigationType.Listening.route) {
                ListeningScreen()
            }

            composable(AppleMusicNavigationType.Archive.route) {
                ArchiveScreen()
            }
        }
    }
}
