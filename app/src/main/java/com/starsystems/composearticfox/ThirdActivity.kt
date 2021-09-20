package com.starsystems.composearticfox

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ThirdActivity: ComponentActivity() {

    var m = Modifier.background(Color.Blue).padding(25.dp)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirdScreenContent()
        }
    }


    /** showSystemUi shows full screen*/
    @Preview(name = "My Preview", showSystemUi = true)
    @Composable
    fun ThirdScreenContent() {
        Column(modifier = Modifier.fillMaxWidth().height(50.dp)
            .border(border = BorderStroke(5.dp, color = Color.Yellow))
            .padding(15.dp)) {
            Text("Item 1", modifier = m)
            }
    }
}