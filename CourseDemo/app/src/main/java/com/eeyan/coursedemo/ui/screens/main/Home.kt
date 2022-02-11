package com.eeyan.coursedemo.ui.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation


//top level definitions
val appIcons =  Icons.Rounded
const val iconUrl = "https://images.unsplash.com/photo-1531727991582-cfd25ce79613?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=387&q=80"
const val samplePhotography = "https://img.icons8.com/external-kmg-design-detailed-outline-kmg-design/344/external-photography-electronics-device-kmg-design-detailed-outline-kmg-design.png"

private data class MenuOps(val title:String, val isActive:Boolean)
data class Course(val title: String, val rating:Double, val time:String, val image:String)

private fun setUpMenuOptions() : List<MenuOps>{
    return listOf(

        MenuOps("All", false),
        MenuOps("Design", true),
        MenuOps("Development", false),
        MenuOps("Marketing", false)

    )
}

private fun setUpCoursesList() : List<Course>{
    
    return listOf(
        
        Course("Adobe Photoshop", 5.0, "4h,45min","https://images.unsplash.com/photo-1617777938240-9a1d8e51a47d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1031&q=80"),
        Course("UI Design - Mobile App", 4.0, "4h,15min","https://images.unsplash.com/photo-1512941937669-90a1b58e7e9c?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"),
        Course("Flat Illustration Design", 4.8, "6h,45min","https://images.unsplash.com/photo-1527484518707-97a54c7a22ca?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"),
        
    )
    
}

@Composable
fun HomeScreen(modifier: Modifier) {

    Surface(
        color = MaterialTheme.colorScheme.surface,
        modifier = modifier
            .fillMaxSize()
    ) {

        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .padding(vertical = 15.dp)) {
            
            TopBar(modifier = modifier)
            
            PageTitle(modifier = modifier)
            
            SearchCard(modifier = modifier)
            
            Banner(modifier = modifier)
            
            MenuSection(modifier = modifier.padding(top = 15.dp))
            
            OptionsList(modifier = modifier)
            
            CourseList(modifier = modifier)
            
        }

    }

}


@Composable
fun TopBar(modifier: Modifier) {

    Row (modifier = modifier
        .fillMaxWidth()
        .padding(2.5.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically){

        Icon(contentDescription = "App Menu", imageVector = appIcons.Menu)
        Image(
            painter = rememberImagePainter(
                data = iconUrl, builder = {
                    crossfade(true)
                    transformations(CircleCropTransformation())
                }),
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .padding(2.dp)
                .border(1.dp, MaterialTheme.colorScheme.primary, CircleShape))

    }

}

@Composable
fun PageTitle(modifier: Modifier) {
    
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 3.dp, bottom = 3.dp)
    ) {
        
        Text(text = "Hello, Ian", color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.headlineSmall)
        Text(text = "What do you want to learn?", color = MaterialTheme.colorScheme.tertiary, style = MaterialTheme.typography.bodyMedium)
        
    }
    
}

@Composable
fun SearchCard(modifier: Modifier) {
    
    Card(modifier = modifier
        .fillMaxWidth()
        .padding(top = 5.dp),
        shape = RoundedCornerShape(10.dp)
        ) {
        
        Row (modifier = modifier
            .fillMaxWidth()
            .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically){

            Icon(imageVector = appIcons.Search, contentDescription = null)

            Text(text = "Search ...",
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp),
                style = TextStyle(color = MaterialTheme.colorScheme.onSurfaceVariant))
        }



        
    }
    
}

@Composable
fun Banner(modifier: Modifier) {
    
    Card(modifier = modifier
        .fillMaxWidth()
        .padding(top = 15.dp),
        shape = RoundedCornerShape(10.dp),
        backgroundColor = MaterialTheme.colorScheme.primary) {
        
        Row(modifier = modifier.padding(15.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly) {
            
            Column(modifier = modifier
                .padding(5.dp)
                .weight(1f, true)) {

                Text(text = "New Course!", fontStyle = FontStyle.Normal, style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.onPrimary)
                
                Text(text = "Photography Class", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onPrimary)
                
                BannerChip(modifier = modifier, info = "See Class")

            }

            Image(painter = rememberImagePainter(
                data = samplePhotography, builder = {
                    crossfade(true)
                }),
                contentDescription = null, modifier = modifier
                    .weight(1f)
                    .size(128.dp), colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimary))

            
        }
        
    }
    
}

@Composable
fun BannerChip(modifier: Modifier, info:String){

    Surface(modifier = modifier
            .padding(5.dp),
            shape = RoundedCornerShape(15.dp),
            color = MaterialTheme.colorScheme.tertiary) {
        
        Text(text = info, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onTertiary, modifier = modifier.padding(15.dp))
        
    }

}

@Composable
fun MenuSection(modifier: Modifier) {
    
    Row(modifier = modifier
        .fillMaxWidth()
        .padding(5.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        
        Text(text = "Course", style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.primary)
        
        Text(text = "View All", style = MaterialTheme.typography.bodySmall)
        
    }
    
}

@Composable
fun OptionsChips(modifier: Modifier, active:Boolean, text:String) {

    Surface(modifier = modifier.padding(5.dp), shape = RoundedCornerShape(25.dp), color = if(active) {MaterialTheme.colorScheme.primary} else MaterialTheme.colorScheme.surface ) {

        Text(text = text, modifier = modifier.padding(15.dp))

    }

}

@Composable
fun OptionsList(modifier: Modifier) {

    LazyRow(modifier = modifier.padding(top = 10.dp), horizontalArrangement = Arrangement.SpaceEvenly){

        items(items = setUpMenuOptions()){

            option -> OptionsChips(modifier = modifier, active = option.isActive, text = option.title)
            
        }

    }

}

@Composable
fun CourseCard(modifier: Modifier, course: Course) {

    Card(modifier = modifier.padding(10.dp), shape = RoundedCornerShape(10.dp), elevation = 3.dp) {

        Row(modifier = modifier.padding(0.dp), verticalAlignment = Alignment.CenterVertically) {

            Image(modifier = modifier
                .padding(end = 15.dp)
                .size(84.dp), painter = rememberImagePainter(
                data = course.image, builder = {
                    crossfade(true)
                    transformations(RoundedCornersTransformation(topLeft = 5f, bottomLeft = 5f))
                }
            ), contentDescription = null)


            Column(modifier = modifier.fillMaxWidth().padding(10.dp), verticalArrangement = Arrangement.SpaceAround) {

                Text(text = course.title, style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.primary)

                Row(modifier = modifier.fillMaxWidth().padding(top = 5.dp), verticalAlignment = Alignment.CenterVertically) {

                    Icon(imageVector = appIcons.Star, contentDescription = null, modifier = modifier.padding(end = 25.dp))

                    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically) {
                        
                        Icon(imageVector = appIcons.AccountBox, contentDescription = null,  modifier = modifier.padding(end = 5.dp))
                        Text(text = course.time, style = MaterialTheme.typography.bodySmall)
                        
                    }

                }

            }


        }

    }



}

@Composable
fun CourseList(modifier: Modifier) {
    
    LazyColumn(modifier = modifier.padding(top = 5.dp)){
        
        items(items = setUpCoursesList()){
            
            course ->  CourseCard(modifier = modifier, course = course)
            
        }
        
    }
    
}
























