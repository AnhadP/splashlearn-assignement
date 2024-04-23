package com.example.findrr.network

import com.example.findrr.data.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {
    @GET("search/movie")
    suspend fun searchMovies(
        @Query("query") query: String,
        @Query("api_key") apiKey: String = "cc7877b4ac9bf564707a0e770eda5ed4"
    ): Response<MoviesResponse>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String = "cc7877b4ac9bf564707a0e770eda5ed4"
    ): Response<MoviesResponse>
}