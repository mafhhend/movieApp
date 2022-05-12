package com.example.movieapp.screens.details

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.movieapp.MainContent
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies
import com.example.movieapp.widgets.MovieRow

@Composable
fun DetailsScreen(navController: NavController, movieId: String?) {
    val movie= getMovies().filter {
        it.id == movieId
    }
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Transparent , elevation = 0.dp) {
            Row(horizontalArrangement = Arrangement.Start) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Arrow Back", modifier = Modifier.clickable {
                    navController.popBackStack()
                })
                Spacer(modifier = Modifier.width(100.dp))
                Text(text = "Movies")
            }
        }
    }) {
            androidx.compose.material.Surface(modifier = Modifier.fillMaxSize()) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    MovieRow(movie = movie[0])
                    Spacer(modifier = Modifier.height(8.dp))
                    Divider()
                    Text(text = "Movie Images")
                    HorizontalScrollableImageView(movie)
                    Button(onClick = {
                        navController.popBackStack()
                    }) {
                        Text(text = "Go Back")
                    }

                }
    }
    }

}

@Composable
private fun HorizontalScrollableImageView(movie: List<Movie>) {
    LazyRow {
        items(movie.first().images) { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(240.dp),
                elevation = 5.dp
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current).data(image).crossfade(true)
                        .build(), contentDescription = "Movie Poster", modifier = Modifier.clip(
                        CircleShape
                    )
                )
            }

        }
    }
}
