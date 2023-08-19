package com.parkjin.music.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.parkjin.music.core.design.R
import com.parkjin.music.core.design.base.LocalColorScheme
import com.parkjin.music.core.design.component.navigation.BottomNavigation
import com.parkjin.music.core.design.component.navigation.BottomNavigationItem

@Composable
fun AppleMusicApp() {
    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryAsState()
        .value
        ?.destination
        ?.route

    val navigate = { route: String ->
        navController.navigate(route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        AppleMusicNavHost(
            modifier = Modifier.weight(1f),
            navController = navController,
        )

        Box(
            modifier = Modifier
                .height(1.dp)
                .background(LocalColorScheme.current.content),
        )

        BottomNavigation {
            BottomNavigationItem(
                icon = ImageVector.vectorResource(R.drawable.icon_listening),
                name = stringResource(id = R.string.word_listening),
                selected = currentRoute == AppleMusicNavigationType.Listening.route,
                onClick = { navigate(AppleMusicNavigationType.Listening.route) },
            )
            BottomNavigationItem(
                icon = ImageVector.vectorResource(R.drawable.icon_music_locker),
                name = stringResource(id = R.string.word_locker),
                selected = currentRoute == AppleMusicNavigationType.Locker.route,
                onClick = { navigate(AppleMusicNavigationType.Locker.route) },
            )
        }
    }
}
