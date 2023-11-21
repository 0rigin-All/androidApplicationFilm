package com.example.myapplication

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController

@Composable
fun Film(
    windowClass: WindowSizeClass,
    viewmodel: MainViewModel,
    navController: NavHostController,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LaunchedEffect(key1 = 0)  {
            viewmodel.getMovies()
        }
        val movies by viewmodel.movies.collectAsStateWithLifecycle()
        FilmGrid(movies = movies, navController)

    }
}

@Composable
fun FilmGrid(movies: List<TmdbMovie>, navController: NavHostController) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(movies) { movie ->
            Movie(movie, navController)
        }
    }
}

@Composable
fun Movie(movie: TmdbMovie, navController: NavHostController){

    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .size(width = 150.dp, height = 250.dp)
            .clickable{
                navController.navigate("detailFilm/${movie.id}" )}
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {


        AsyncImage(
            model = "https://image.tmdb.org/t/p/w342${movie.poster_path}",
            contentDescription = "movie.original_title"
           )

        Text(
            text = movie.original_title,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }}

}
