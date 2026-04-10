package com.mahjongslice.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val InkIvoryScheme = darkColorScheme(
    primary = AccentRed,
    secondary = AccentGold,
    background = BackgroundDark,
    surface = BackgroundMid,
    onPrimary = TileIvory,
    onSecondary = BackgroundDark,
    onBackground = WarmWhite,
    onSurface = WarmWhite,
)

@Composable
fun MahjongSliceTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = InkIvoryScheme,
        content = content
    )
}
