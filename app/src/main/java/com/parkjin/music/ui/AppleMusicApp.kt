package com.parkjin.music.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
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

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        AppleMusicNavHost(
            modifier = Modifier.weight(1f),
            navController = navController,
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.5.dp)
                .background(LocalColorScheme.current.divider),
        )

        BottomNavigation {
            BottomNavigationItem(
                icon = ImageVector.vectorResource(R.drawable.icon_listening),
                name = stringResource(id = R.string.word_listening),
                selected = currentRoute == AppleMusicNavigationType.Listening.route,
                onClick = { navController.navigate(AppleMusicNavigationType.Listening) },
            )
            BottomNavigationItem(
                icon = ImageVector.vectorResource(R.drawable.icon_archive),
                name = stringResource(id = R.string.word_archive),
                selected = currentRoute == AppleMusicNavigationType.Archive.route,
                onClick = { navController.navigate(AppleMusicNavigationType.Archive) },
            )
        }
    }
}
