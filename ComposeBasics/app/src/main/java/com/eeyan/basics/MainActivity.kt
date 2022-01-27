package com.eeyan.basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.eeyan.basics.ui.theme.BasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsTheme {
                // A surface container using the 'background' color from the theme
                MyApp()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    var expanded by remember{ mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        if(expanded) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)){

        Row(modifier = Modifier.padding(24.dp)) {

            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding.coerceAtLeast(0.dp))) {
                Text(text = "Hello, ")
                Text(text = "$name !", style = MaterialTheme.typography.h3.copy(
                    fontWeight = FontWeight.ExtraBold
                ))
            }
            OutlinedButton(onClick = { expanded = !expanded}) {
                Text(text = if(expanded) "Show Less" else "Show more")
            }
        }
        
        
    }


}



@Composable
private fun CardContent(name: String){

    var expanded by remember {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {


        Column(modifier = Modifier
            .padding(12.dp)
            .weight(1f)) {
            
            Text(text = "Hello, ")
            Text(text = name, style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.Bold))
            
            if(expanded) {
                Text(text = ("Composem ipsum color sit lazy, " +
                        "padding theme elit, sed do bouncy. ").repeat(4))
            }
            
        }

        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = if (expanded) {
                    stringResource(R.string.show_less)
                } else {
                    stringResource(R.string.show_more)
                }

            )
        }

    }

}

@Composable
fun OnBoardingScreen(onContinueClicked : () -> Unit) {

    Surface{

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "Welcome to the Basics Codelab!")
            Button(
                modifier = Modifier.padding(24.dp),
                onClick = onContinueClicked) {

                Text(text = "Continue")

            }

        }

    }

}

@Composable
private fun GreetingCard(name: String) {
    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        CardContent(name)
    }
}

@Preview(showBackground = true, name = "Text Preview", showSystemUi = true)
@Composable
fun DefaultPreview() {
    BasicsTheme {
        MyApp()
    }
}

@Composable
private fun Greetings(names: List<String> = listOf("Android", "Jetpack Compose")){
    Column (modifier = Modifier.padding(vertical = 4.dp)){
        names.forEach {
            Greeting(name = it)
        }
    }
}

@Composable
private fun LazyGreetings(names: List<String> = List(1000){"$it"}) {

    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)){

        items(items = names){
            name -> GreetingCard(name = name)
        }

    }

}


@Composable
private fun MyApp(){
    var shouldShowOnBoarding by rememberSaveable { mutableStateOf(true) }

    if(shouldShowOnBoarding){
        OnBoardingScreen(onContinueClicked = {shouldShowOnBoarding = false})
    }else{
        LazyGreetings()
    }

}