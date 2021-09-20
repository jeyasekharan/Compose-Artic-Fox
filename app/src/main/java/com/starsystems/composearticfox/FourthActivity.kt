package com.starsystems.composearticfox

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.starsystems.composearticfox.search.SearchActivityV2
import com.starsystems.composearticfox.ui.theme.MyApplicationTheme2

class FourthActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme2(false) {
                FirstScreen()
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun FirstScreen(myViewModel: FourthViewModel = FourthViewModel()) {
        val name:String by myViewModel.name.observeAsState("")
        FirstScreenContent(name) { myViewModel.onNameChanged(it, it) }
    }


    @Composable
    fun FirstScreenContent(name:String, onNameChange: (String) -> Unit) {

        Column(modifier = Modifier.fillMaxSize()) {
            TextField(value = name, onValueChange = onNameChange, label = {Text("Enter name")})

            ExpandableCard("Title goes here", "Hello everyone")
            Log.e("textfield", "ScreenContent: $name", )
        }
    }


    @Composable
    fun ExpandableCard(title:String, body: String) {
        var expanded by remember { mutableStateOf(false) }

        Card {
            Column(modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Gray), horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround) {
                Text(text = title)

                if(expanded) {
                    Text(text = body)
                }
                
                Spacer(modifier = Modifier
                    .width(20.dp)
                    .height(10.dp))

                CustomItem(weight = 3f, color = MaterialTheme.colors.primary)

                CustomItem(weight = 3f, color = MaterialTheme.colors.primary)

                Row(Modifier.weight(3f)) {
                    CustomItem(color = MaterialTheme.colors.background)
                }
            }
        }
    }

    @Composable
    fun ColumnScope.CustomItem(weight: Float, color: Color = MaterialTheme.colors.primary) {
        Surface(modifier = Modifier
            .width(200.dp)
            .weight(weight), color = color) {
            val context = LocalContext.current
                 Button(onClick = {startActivity(Intent(context, SearchActivityV2::class.java)) }) {
                    Text(text = "SearchActivity")
                }
        }
    }

    @Composable
    fun RowScope.CustomItem(color: Color = MaterialTheme.colors.primary) {
        Surface(modifier = Modifier
            .height(200.dp)
            .fillMaxSize(), color = color) {

        }
    }
}