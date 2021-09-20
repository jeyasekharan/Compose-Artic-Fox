package com.starsystems.composearticfox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

class SecondActivity : ComponentActivity() {

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SecondActivityScreen()
        }
    }

    @Preview(showBackground = true)
    @ExperimentalAnimationApi
    @Composable
    fun SecondActivityScreen() {
        var title by remember {
            mutableStateOf("There")
        }
        var btnVisible by remember {
            mutableStateOf(true)
        }
        
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { btnVisible = !btnVisible }) {
                Text(
                    "Hi $title"
                )
            }

            AnimatedVisibility(visible = btnVisible,

                exit = fadeOut(
                    // Overwrites the default animation with tween
                    animationSpec = tween(durationMillis = 1250)
                ))
            {
                Text(
                    "Hi $title"
                )
            }
        }
    }



}