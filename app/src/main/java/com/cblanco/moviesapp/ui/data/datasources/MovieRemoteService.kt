package com.cblanco.moviesapp.ui.data.datasources

import com.cblanco.moviesapp.ui.data.model.RemoteMovieDetail
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieRemoteService {

    @GET("movie/{moveId}")
    suspend fun getMovieDetail(
        @Path("moveId") moveId: Int,
        @Query("api_key") apiKey: String
    ): RemoteMovieDetail

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String
    ): MovieServiceResult

}