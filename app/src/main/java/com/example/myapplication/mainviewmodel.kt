package com.example.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainViewModel : ViewModel() {
    val api_key = "1aafb842f039fc0eea914e8e3da318ce"
    val retrofit = Retrofit.Builder()
    .baseUrl("https://api.themoviedb.org/3/")
    .addConverterFactory(MoshiConverterFactory.create())
    .build();


    val api = retrofit.create(Api::class.java)


    val movies = MutableStateFlow<List<TmdbMovie>>(listOf())
    var movie = MutableStateFlow<TmdbMovie> (TmdbMovie())

    fun getMovie(id:String){
        viewModelScope.launch {

            movie.value = api.movieById(id = id, api_key = api_key)
        }
    }

    fun getMovies() {
        viewModelScope.launch {

            movies.value = api.lastmovies(api_key).results
        }
    }
}
