package com.eeyan.layouts.ui.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import kotlinx.coroutines.launch


@Composable
fun LayoutsCodelab() {
    
    Scaffold (

        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Compose Layouts")
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Favorite, contentDescription = null )
                    }
                })
            },
        
        bottomBar = {
            
            BottomAppBar (modifier = Modifier.fillMaxWidth(), cutoutShape = CircleShape){

                setUpList().forEach {
                    BottomMenu(icon = it.first, desc = it.second)
                }
            }
            
        }

    ){ innerPadding ->
        BodyContent(modifier = Modifier
            .padding(innerPadding)
            .padding(8.dp))
    }
    
}


@Composable
fun BottomMenu(icon:ImageVector, desc:String?) {

    IconButton(onClick = { /*TODO*/ }) {
        Icon(icon, contentDescription = desc)
    }

}

private fun setUpList() : List<Pair<ImageVector, String>>{

    val one = Pair(Icons.Filled.Home, "Home Icon")
    val two = Pair(Icons.Filled.Search, "Search Icon")
    val three = Pair(Icons.Filled.Settings, "Settings")

    return listOf(one, two, three)

}


@Composable
fun BodyContent(modifier: Modifier = Modifier) {

    Column(modifier = modifier) {

        Text(text = "Hello there!")
        Text(text = "Welcome to compose layouts")

        ScrollingList()

    }

}


@Composable
fun ImageListItem(index: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = rememberImagePainter(
                data = "https://developer.android.com/images/brand/Android_Robot.png"
            ),
            contentDescription = "Android Logo",
            modifier = Modifier.size(50.dp)
        )
        Spacer(Modifier.width(10.dp))
        Text("Item #$index", style = MaterialTheme.typography.subtitle1)
    }
}

@Composable
fun ScrollingList() {
    val listSize = 100
    // We save the scrolling position with this state
    val scrollState = rememberLazyListState()
    // We save the coroutine scope where our animated scroll will be executed
    val coroutineScope = rememberCoroutineScope()

    Column {
        Row {
            Button(onClick = {
                coroutineScope.launch {
                    // 0 is the first item index
                    scrollState.animateScrollToItem(0)
                }
            }) {
                Text("Scroll to the top")
            }

            Button(onClick = {
                coroutineScope.launch {
                    // listSize - 1 is the last index of the list
                    scrollState.animateScrollToItem(listSize - 1)
                }
            }) {
                Text("Scroll to the end")
            }
        }

        LazyColumn(state = scrollState) {
            items(listSize) {
                ImageListItem(it)
            }
        }
    }
}