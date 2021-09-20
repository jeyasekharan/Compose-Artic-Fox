package com.commusoft.v4.Search.Activities

import android.graphics.drawable.Icon
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*

import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class SearchActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SearchScreen()
        }
    }


    /** Search screen composable function*/
    @Composable
    fun SearchScreen() {
        ScreenContent()
    }


    /** The content of the screen */
    @Preview(showBackground = true)
    @Composable
    fun ScreenContent() {
        Scaffold(
            topBar = { SearchBar() },
            floatingActionButton = {
                FloatingActionButton(onClick = {}) {
                Icon(Icons.Filled.Add, "", tint = Color.White)
            }},
            content = {
                innerpadding ->


            }
        )

        /* Column(modifier = Modifier.fillMaxSize()) {
                    FloatingActionButton(onClick = {}) {
                        Icon(Icons.Filled.Add, "")
                    }
                }*/
    }


    @Composable
    fun SearchBar() {
        Row(modifier = Modifier.fillMaxSize()) {

            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                trailingIcon = { Icon(Icons.Filled.Search, "", tint = Color.Black) },
                label = { Text("Search for a customer, estimate or job") },
                value = "",
                onValueChange = {

                },
                shape = RoundedCornerShape(8.dp),
            )
        }
    }
}