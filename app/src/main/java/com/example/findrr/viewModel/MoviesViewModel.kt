package com.example.findrr.viewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.findrr.data.Movie
import com.example.findrr.network.TMDBService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MoviesViewModel: ViewModel() {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(TMDBService::class.java)

    private val _movies = mutableStateListOf<Movie>()
    val movies: List<Movie> get() = _movies

    fun searchMovies(query: String) {
        viewModelScope.launch {
            val response = service.searchMovies(query)
            if (response.isSuccessful) {
                _movies.clear()
                response.body()?.results?.let {
                    _movies.addAll(it)
                }
            }
        }
    }
    fun getTopRatedMovies() {
        viewModelScope.launch {
            val response = service.getTopRatedMovies()
            if (response.isSuccessful) {
                _movies.clear()
                response.body()?.results?.let {
                    _movies.addAll(it)
                }
            }
        }
    }
}