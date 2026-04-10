package com.mahjongslice.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.mahjongslice.R
import com.mahjongslice.ui.theme.BackgroundDark

@Composable
fun AppBackground(
    modifier: Modifier = Modifier,
    bgAlpha: Float = 1f,
    @DrawableRes background: Int = R.drawable.bg_menu_texture,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(BackgroundDark)
    ) {
        Image(
            painter = painterResource(background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .alpha(bgAlpha),
        )
        content()
    }
}
