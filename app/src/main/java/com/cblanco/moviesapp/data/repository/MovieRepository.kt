package com.cblanco.moviesapp.data.repository

import com.cblanco.moviesapp.data.datasources.RemoteDataSource
import com.cblanco.moviesapp.data.model.Movie
import com.cblanco.moviesapp.ui.data.model.RemoteMovieDetail
import javax.inject.Inject
import javax.inject.Named


class MovieRepository @Inject constructor(private val remoteDataSource: RemoteDataSource,
                      @Named("apiKey")  private val apiKey:String) {

    suspend fun getMovieDetail(movieId: Int):RemoteMovieDetail = remoteDataSource.getMovieDetail(movieId, apiKey)

    suspend fun getPopularMovies():List<Movie> = remoteDataSource.getPopularMovies(apiKey)

}