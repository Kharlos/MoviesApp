package com.cblanco.moviesapp.usecases

import com.cblanco.moviesapp.data.model.Movie
import com.cblanco.moviesapp.data.repository.MovieRepository
import com.cblanco.moviesapp.ui.data.model.RemoteMovieDetail
import javax.inject.Inject


class LoadMovies @Inject constructor(private val repository: MovieRepository) {

    suspend fun getMovieDetail(movieId: Int): RemoteMovieDetail = repository.getMovieDetail(movieId)

    suspend fun getPopularMovies():List<Movie> = repository.getPopularMovies()

}