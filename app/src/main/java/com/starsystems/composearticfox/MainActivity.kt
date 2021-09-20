package com.starsystems.composearticfox

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.starsystems.composearticfox.search.SearchActivityV2
import com.starsystems.composearticfox.ui.theme.MyApplicationTheme

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
            {
                MyScreenContent()
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun MyScreenContent(names: List<String> = List(1000) {"Hello Android $it"}) {
    var counterState by remember {
        mutableStateOf(0)
    }

    Column(modifier = Modifier.border(BorderStroke(1.dp, color = Color.Red), shape = RectangleShape)) {
        // NamesList(names = names, modifier = Modifier.weight(1f))
        Counter(count = counterState,
            updateCount = {  newCount ->
                counterState = newCount
            })

        Row(modifier = Modifier.background(color = Color.White)) {


        }

        Row() {
            Column(
                Modifier.weight(1f)) {
                StartSecondActivity()
            }

            Column(
                Modifier.weight(1f)) {
                StartThirdActivity()
            }

            Column(
                Modifier.weight(1f)) {
                StartFourthActivity()
            }
        }

        if(counterState > 5) {
            Text(text = "I love to count $counterState")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(modifier = Modifier.background(color = Color(0xFFE2E2E3)).height(50.dp), verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly) {
                StartCustomActivity("FourthActivity")
            }

            Divider(modifier = Modifier.width(1.dp).fillMaxHeight())

            Column(modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                StartCustomActivity("FifthActivity")
            }
        }
    }
}


@Composable
fun StartCustomActivity(name: String) {
    val context = LocalContext.current
    Button(onClick = { context.startActivity(Intent(context, FourthActivity::class.java)) }) {
        Text(text = "FourthActivity")
    }
}

@Composable
fun StartSecondActivity() {
    val context = LocalContext.current
    Button(modifier = Modifier.padding(10.dp),onClick = { context.startActivity(Intent(context, SecondActivity::class.java)) }) {
        Text(text = "Second Activity")
    }
}

@Composable
fun StartThirdActivity() {
    val context = LocalContext.current
    Button(modifier = Modifier.padding(10.dp), onClick = { context.startActivity(Intent(context, ThirdActivity::class.java)) }) {
        Text(text = "Third Activity")
    }
}

@ExperimentalFoundationApi
@Composable
fun StartFourthActivity() {
    val context = LocalContext.current
    Button(modifier = Modifier.padding(10.dp), onClick = { context.startActivity(Intent(context, SearchActivityV2::class.java)) }) {
        Text(text = "Search Activity")
    }
}

@Composable
fun NamesList(names: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(items = names) {
            Greeting(name = it)
            Divider()
        }
    }
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(onClick = { updateCount(count + 1) }) {
        Text(text = "I have been clicked $count times")
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MyApplicationTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var isSelected by remember {
        mutableStateOf(false)
    }
    val targetColor by animateColorAsState(targetValue =
    if(isSelected) Color.Red else Color.Transparent,
        animationSpec = tween(durationMillis = 1000)
    )

    Surface(color = targetColor) {
        Text(text = "Hello $name!", modifier = modifier
            .clickable { isSelected = !isSelected }
            .padding(16.dp))
    }
}

@ExperimentalFoundationApi
@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    MyApp()
    {
        MyScreenContent()
    }
}