package com.eeyan.layouts.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun LayoutsCodelab() {
    
    Scaffold (
        topBar ={ TopAppBar(title = { Text(text = "Compose Layouts")}) }
            ){ innerPadding ->
        BodyContent(modifier = Modifier.padding(innerPadding))
    }
    
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {

    Column(modifier = modifier) {

        Text(text = "Hello there!")
        Text(text = "Welcome to compose layouts")

    }

}