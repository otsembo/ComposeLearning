package com.eeyan.coursedemo.ui.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation


//top level definitions
private val appIcons =  Icons.Rounded
private const val iconUrl = "https://img.icons8.com/external-detailed-filled-line-rakhmat-setiawan/344/external-protection-seo-website-detailed-filled-line-rakhmat-setiawan.png"

@Composable
fun HomeScreen(modifier: Modifier) {

    Surface(
        color = MaterialTheme.colorScheme.surfaceVariant,
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
            modifier = Modifier.size(64.dp).padding(2.dp).border(1.dp, MaterialTheme.colorScheme.primary, CircleShape))

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
        shape = RoundedCornerShape(5.dp)
        ) {
        
        Row (modifier = modifier
            .fillMaxWidth()
            .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically){

            Icon(imageVector = appIcons.Search, contentDescription = null)

            Text(text = "Search ...",
                modifier = modifier.fillMaxWidth().padding(start = 10.dp),
                style = TextStyle(color = MaterialTheme.colorScheme.onSurfaceVariant))
        }



        
    }
    
}