package com.cblanco.moviesapp.data.datasources

import com.cblanco.moviesapp.data.model.Movie
import com.cblanco.moviesapp.ui.data.model.RemoteMovieDetail

interface RemoteDataSource {

    suspend fun getMovieDetail(movieId:Int, apiKey: String): RemoteMovieDetail

    suspend fun getPopularMovies(apiKey: String): List<Movie>

}