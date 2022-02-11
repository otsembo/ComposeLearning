package com.eeyan.coursedemo.ui.screens.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.icons.rounded.ExitToApp
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.eeyan.coursedemo.ui.screens.main.BannerChip
import com.eeyan.coursedemo.ui.screens.main.appIcons
import com.eeyan.coursedemo.ui.screens.main.samplePhotography

@Composable
fun DetailPage(modifier: Modifier) {

    Surface(
        color = MaterialTheme.colorScheme.surface,
        modifier = modifier.fillMaxSize()
    ) {

        Column(modifier = modifier
            .fillMaxSize()
            .padding(10.dp)
            .padding(top = 15.dp)) {

            TopNavigator(modifier = modifier)
            
            CourseBanner(modifier = modifier)
            
            CourseContent(modifier = modifier)


        }

    }

}


@Composable
fun TopNavigator(modifier: Modifier) {
    
    Icon(imageVector = appIcons.KeyboardArrowLeft, contentDescription = null, modifier = modifier.padding(2.5.dp ))
    
}

@Composable
fun CourseBanner(modifier: Modifier) {

    Row(modifier = modifier
        .fillMaxWidth()
        .padding(15.dp)
        .padding(top = 50.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically){

        Image(
            painter = rememberImagePainter(
                data = samplePhotography, builder = {
                    crossfade(1500)
                }), contentDescription = null, modifier = modifier.size(200.dp))

    }



}

@Composable
fun CourseContent(modifier: Modifier ) {

    Card(modifier = modifier.fillMaxSize(),
        shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp),
        backgroundColor = MaterialTheme.colorScheme.primary) {

        Column(modifier = modifier) {

            SimpleDash(modifier = modifier)

            BannerChip(modifier = modifier, info = "New Course")

        }


        
    }

}

@Composable
fun SimpleDash(modifier: Modifier) {
    
    Row(modifier = modifier
        .fillMaxWidth()
        .height(10.dp)
        .padding(start = 75.dp, end = 75.dp, top = 5.dp, bottom = 5.dp),
        horizontalArrangement = Arrangement.Center) {
     
        Card(modifier = modifier
            .padding(10.dp)
            .fillMaxWidth(), backgroundColor = MaterialTheme.colorScheme.onPrimary, shape = RoundedCornerShape(100.dp)) {
            Text(text = "", modifier = modifier.padding(0.01.dp), color = MaterialTheme.colorScheme.secondary )
        }
        
    }
    
}

























































