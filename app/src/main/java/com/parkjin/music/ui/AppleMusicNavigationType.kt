package com.parkjin.music.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

enum class AppleMusicNavigationType(
    val route: String,
) {
    Listening(route = "listening"),
    Archive(route = "archive"),
}

fun NavController.navigate(type: AppleMusicNavigationType) {
    navigate(type.route) {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}
