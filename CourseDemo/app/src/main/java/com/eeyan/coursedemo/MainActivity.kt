package com.eeyan.coursedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.eeyan.coursedemo.ui.screens.main.HomeScreen
import com.example.compose.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                HomePage()
            }
        }

    }
}



@Preview(showBackground = true)
@Composable
private fun HomePage(){
    HomeScreen(modifier = Modifier)
}


