package com.example.movieapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies
import com.example.movieapp.navigation.MovieNavigation
import com.example.movieapp.navigation.MovieScreens
import com.example.movieapp.ui.theme.MovieAppTheme
import com.example.movieapp.widgets.MovieRow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MovieNavigation()

            }
        }
    }
}

@Composable
fun MyApp(content:@Composable () ->Unit){
    MovieAppTheme {
    content()
    }
}

@Composable
fun MainContent(navController: NavController,movieList:List<Movie> = getMovies()){
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn{
            items(items=movieList){
                MovieRow(movie = it){ movie->
                    navController.navigate(route = MovieScreens.DetailsScreen.name + "/$movie")
                }
            }
        }
    }
}
@Preview
@Composable
fun DefaultPreview(){
    MyApp {
        MovieNavigation()
    }
}