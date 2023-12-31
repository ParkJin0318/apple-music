package com.parkjin.music.core.design.component.navigation

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.parkjin.music.core.design.R
import com.parkjin.music.core.design.theme.AppleMusicTheme
import com.parkjin.music.core.design.theme.LocalColorScheme
import com.parkjin.music.core.design.theme.LocalTypography
import com.parkjin.music.core.design.element.icon.Icon
import com.parkjin.music.core.design.element.text.Text

@Composable
fun BottomNavigation(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(LocalColorScheme.current.background)
            .padding(horizontal = 20.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        content()
    }
}

@Composable
fun BottomNavigationItem(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    name: String,
    selected: Boolean = false,
    onClick: () -> Unit,
) {
    val color by animateColorAsState(
        targetValue = if (selected) {
            LocalColorScheme.current.secondary
        } else {
            LocalColorScheme.current.content200
        },
        animationSpec = spring(dampingRatio = 3f),
        label = "bottomNavigationItemColor",
    )

    Column(
        modifier = modifier.clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            imageVector = icon,
            size = 32.dp,
            tint = color,
        )

        Text(
            text = name,
            style = LocalTypography.current.caption1,
            color = color,
        )
    }
}

@Preview
@Composable
fun PreviewBottomNavigation() {
    AppleMusicTheme {
        BottomNavigation {
            BottomNavigationItem(
                icon = ImageVector.vectorResource(R.drawable.icon_listening),
                name = stringResource(id = R.string.word_listening),
                selected = true,
                onClick = {},
            )
            BottomNavigationItem(
                icon = ImageVector.vectorResource(R.drawable.icon_archive),
                name = stringResource(id = R.string.word_archive),
                onClick = {},
            )
        }
    }
}
