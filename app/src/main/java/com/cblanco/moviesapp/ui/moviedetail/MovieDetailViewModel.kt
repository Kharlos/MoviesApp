package com.cblanco.moviesapp.ui.moviedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cblanco.moviesapp.ui.data.model.RemoteMovieDetail
import com.cblanco.moviesapp.usecases.LoadMovies
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(private val loadMovies: LoadMovies) : ViewModel() {

    private val _movieDetail = MutableLiveData<RemoteMovieDetail>()
    val movieDetail: LiveData<RemoteMovieDetail> = _movieDetail

    fun loadMovieDetail(movieId: Int) {
        val handler = CoroutineExceptionHandler { coroutineContext, throwable ->

        }

        viewModelScope.launch(Dispatchers.IO + handler) {
            _movieDetail.postValue(loadMovies.getMovieDetail(movieId))
        }
    }

}