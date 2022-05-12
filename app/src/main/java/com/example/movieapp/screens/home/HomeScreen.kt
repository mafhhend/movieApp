package com.example.movieapp.screens.home

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.MainContent

@Composable
fun HomeScreen(navController: NavController){
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Transparent,elevation = 0.dp) {
            Text(text = "Movies")
        }
    }) {
        MainContent(navController)
    }
}