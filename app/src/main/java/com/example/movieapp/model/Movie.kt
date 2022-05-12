package com.example.movieapp.model

data class Movie(
    val id: String,
    val title: String,
    val year: String,
    val genre: String,
    val director: String,
    val actors:String,
    val plot: String,
    val poster: String,
    val images:List<String>,
    val rating:String
)

fun getMovies():List<Movie>{
    return listOf(
        Movie(
            id = "tt0499549",
            title = "Movie1",
            year = "2009",
            genre = "Action, Adventure, Fantasy",
            director = "James Cameron",
            actors = "actor1, actor2, actor3, actor4, actor5",
            plot = "plot plot plot",
            poster = "https://s3.amazonaws.com/thumbnails.venngage.com/template/4c5cb3e3-ab2a-4cd9-bfdb-cfe7c879cb1a.png",
            images = listOf(
                "https://s3.amazonaws.com/thumbnails.venngage.com/template/4c5cb3e3-ab2a-4cd9-bfdb-cfe7c879cb1a.png",
                "https://s3.amazonaws.com/thumbnails.venngage.com/template/4c5cb3e3-ab2a-4cd9-bfdb-cfe7c879cb1a.png"
            ),
            rating = "7.9"),
        Movie(
            id = "tt0499549",
            title = "Movie2",
            year = "2009",
            genre = "Action, Adventure, Fantasy",
            director = "James Cameron",
            actors = "actor1, actor2, actor3, actor4, actor5",
            plot = "plot plot plot",
            poster = "https://s3.amazonaws.com/thumbnails.venngage.com/template/4c5cb3e3-ab2a-4cd9-bfdb-cfe7c879cb1a.png",
            images = listOf(
                "https://s3.amazonaws.com/thumbnails.venngage.com/template/4c5cb3e3-ab2a-4cd9-bfdb-cfe7c879cb1a.png",
                "https://s3.amazonaws.com/thumbnails.venngage.com/template/4c5cb3e3-ab2a-4cd9-bfdb-cfe7c879cb1a.png"
            ),
            rating = "4.9")

        )
}
