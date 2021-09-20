package com.starsystems.composearticfox.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun BlueDivider(width: Dp = 2.dp, height: Dp = 10.dp, paddingValues: PaddingValues = PaddingValues()) {
    Divider(color = Color(0xFF9ED1F3), thickness = 1.dp, modifier = Modifier
        .padding(paddingValues = paddingValues)
        .width(width)
        .height(height))
}

val blueDivider: @Composable () -> Unit = { Divider(color = Color(0xFF9ED1F3)) }
val spacer: @Composable () -> Unit = { Spacer(modifier = Modifier.padding(0.dp))}



val cardModifier = Modifier.width(10.dp).height(10.dp)

