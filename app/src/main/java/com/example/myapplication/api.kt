package com.example.myapplication

import androidx.compose.ui.graphics.painter.Painter
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("trending/movie/week")
    suspend fun lastmovies(@Query("api_key") api_key: String): TmdbMovieResult

    @GET("movie/{id}")
    suspend fun movieById(@Path("id") id: String, @Query("api_key") api_key: String): TmdbMovie
    }
