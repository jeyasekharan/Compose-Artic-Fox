package com.starsystems.composearticfox.search

import android.graphics.drawable.Icon
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*

import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.starsystems.composearticfox.ui.theme.BlueDivider
import com.starsystems.composearticfox.ui.theme.FoundationPrimary
import com.starsystems.composearticfox.ui.theme.MyApplicationTheme


class SearchActivityV2 : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                SearchScreen()
            }
        }
    }


    /** Search screen composable function*/
    @Composable
    fun SearchScreen() {
        ScreenContent()
    }


    /** The content of the screen */
/*
    @Preview(showBackground = true)
*/
    @Preview(showSystemUi = true)
    @Composable
    fun ScreenContent() {
        Scaffold(
            topBar = {
                Surface(elevation = 5.dp) {
                    TopAppBar(
                        elevation = 0.dp,
                        backgroundColor = Color.White,
                        modifier = Modifier.padding(
                            start = 5.dp, end = 5.dp, bottom = 10.dp, top = 10.dp
                        )
                    ) {
                        SearchBar()
                    }
                }
            },
            floatingActionButton = {
                FloatingActionButton(onClick = {}, backgroundColor = FoundationPrimary) {
                    Icon(Icons.Filled.Add, " ", tint = Color.White)
                }
            },
            content = { innerPadding ->
                Content(innerPadding = innerPadding)
            }
        )
    }


    @Composable
    fun SearchBar() {
        var displaySearchTextField by remember {
            mutableStateOf(true)
        }

        if (displaySearchTextField) {
            /** The layout for search textfield*/
            Row(modifier = Modifier
                .fillMaxSize()
                .clickable {
                    Log.e("displaySearch", "$displaySearchTextField")
                    displaySearchTextField = !displaySearchTextField

                }) {
                TextField(
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color(0xFFEEEEEE),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .fillMaxWidth(),
                    trailingIcon = { Icon(Icons.Filled.Search, "", tint = Color.Black) },
                    label = { Text("Search for a customer, estimate or job") },
                    value = "",
                    onValueChange = {

                    },
                    shape = RoundedCornerShape(8.dp),
                )
            }
        } else {
            SearchField2()
        }
    }


    @Composable
    fun SearchField2() {
        /** The layout for search textfield */
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)) {
            Column(
                Modifier
                    .weight(1f)
                    .padding(start = 10.dp)) {
                Text(text = "Search", fontWeight = FontWeight.Companion.Bold, fontSize = 15.sp)
            }

            Column(
                Modifier
                    .weight(1f)
                    .padding(end = 10.dp), horizontalAlignment = Alignment.End) {
                Icon(Icons.Filled.Search, "", tint = Color.Black)
            }
        }
    }


    @Composable
    fun Content(innerPadding: PaddingValues) {
        Spacer(modifier = Modifier.padding(innerPadding))
        ResultItem()
    }

    @Composable
    fun ResultItem(name: String = "Ramu", address: String = "Asarimar south strret") {
        Card(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .background(color = Color(0xFFF3F4F6))
        ) {
            Column(
                modifier = Modifier
                    .background(color = Color(0xFFF3F4F6))
                    .padding(start = 10.dp, top = 10.dp, end = 10.dp, bottom = 15.dp)
            ) {
                Text(
                    text = name,
                    color = Color(0xFF303030),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = address, fontSize = 12.sp, color = Color(0xFF979797))
            }
        }
    }

    @Composable
    fun BlueDivider1() {
        BlueDivider()
    }
}