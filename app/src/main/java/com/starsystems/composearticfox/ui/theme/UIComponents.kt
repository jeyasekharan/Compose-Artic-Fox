package com.starsystems.composearticfox.ui.theme

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun BlueDivider(width: Dp = 2.dp, height: Dp = 10.dp) {
    Divider(color = Color(0xFF9ED1F3), thickness = 1.dp, modifier = Modifier
        .width(width)
        .height(height))
}

val blueDivider: @Composable () -> Unit = { Divider(color = Color(0xFF9ED1F3)) }
val spacer: @Composable () -> Unit = { Spacer(modifier = Modifier.padding(0.dp))}



val cardModifier = Modifier.width(10.dp).height(10.dp)

