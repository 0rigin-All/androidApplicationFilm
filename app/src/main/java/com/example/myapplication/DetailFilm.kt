package com.example.myapplication

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import coil.compose.AsyncImage


@Composable
fun DetailFilm(navController: NavHostController, viewmodel: MainViewModel, id: String?) {
    if(id!=null){
        LaunchedEffect(key1 = 0)  {
            viewmodel.getMovie(id)
        }
        val movie by viewmodel.movie.collectAsStateWithLifecycle()
        DetailMovie(movie = movie)
    }

}

@Composable
fun DetailMovie(movie: TmdbMovie

){
    AsyncImage(
        model = "https://image.tmdb.org/t/p/w500${movie.poster_path}",
        contentDescription = "movie.original_title"
    )
}