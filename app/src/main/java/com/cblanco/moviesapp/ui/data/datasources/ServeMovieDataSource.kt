package com.cblanco.moviesapp.ui.data.datasources

import androidx.lifecycle.MutableLiveData
import com.cblanco.moviesapp.data.datasources.RemoteDataSource
import com.cblanco.moviesapp.data.model.Movie
import com.cblanco.moviesapp.ui.data.model.RemoteMovieDetail
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Flow
import com.cblanco.moviesapp.ui.data.datasources.MovieResult as RemoteMovie


class ServeMovieDataSource (private val movieRemotService: MovieRemoteService) : RemoteDataSource {

    override suspend fun getMovieDetail(movieId: Int, apiKey: String): RemoteMovieDetail {
        return movieRemotService.getMovieDetail(movieId, apiKey)
    }

    override suspend fun getPopularMovies(apiKey: String): List<Movie> {
        val moviesResult = movieRemotService.getPopularMovies(apiKey)
        return moviesResult.results!!.map { remoteMovie: RemoteMovie ->
            Movie(
                remoteMovie.id,
                remoteMovie.originalTitle,
                remoteMovie.backdropPath
            )
        }
    }

    /*
    var livedata = MutableLiveData<List<Movie>>()

    override suspend fun getPopularMovies(apiKey: String): Disposable {
        return movieRemotService.getPopularMovies(apiKey)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                it.results!!.map { remoteMovie->
                    Movie(
                        remoteMovie.id,
                        remoteMovie.originalTitle,
                        remoteMovie.posterPath
                    )
                }
            }
            .subscribe({
                livedata.value = it
            }, {

            })

    }
     */

}
