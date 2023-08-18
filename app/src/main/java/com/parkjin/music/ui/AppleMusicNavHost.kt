package com.parkjin.music.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.parkjin.music.core.design.R
import com.parkjin.music.core.design.base.LocalColorScheme
import com.parkjin.music.core.design.component.navigation.BottomNavigation
import com.parkjin.music.core.design.component.navigation.BottomNavigationItem
import com.parkjin.music.feature.play.PlayScreen

@Composable
fun AppleMusicNavHost(
    modifier: Modifier = Modifier,
) {
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

    Column {
        NavHost(
            modifier = modifier.weight(1f),
            navController = navController,
            startDestination = AppleMusicBottomMenu.Play.route,
        ) {
            composable(AppleMusicBottomMenu.Play.route) {
                PlayScreen()
            }

            composable(AppleMusicBottomMenu.Locker.route) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(LocalColorScheme.current.primary),
                )
            }
        }

        BottomNavigation {
            BottomNavigationItem(
                icon = ImageVector.vectorResource(R.drawable.icon_play),
                name = stringResource(id = R.string.word_listening),
                selected = currentRoute == AppleMusicBottomMenu.Play.route,
                onClick = { navigate(AppleMusicBottomMenu.Play.route) },
            )
            BottomNavigationItem(
                icon = ImageVector.vectorResource(R.drawable.icon_music_locker),
                name = stringResource(id = R.string.word_locker),
                selected = currentRoute == AppleMusicBottomMenu.Locker.route,
                onClick = { navigate(AppleMusicBottomMenu.Locker.route) },
            )
        }
    }
}
