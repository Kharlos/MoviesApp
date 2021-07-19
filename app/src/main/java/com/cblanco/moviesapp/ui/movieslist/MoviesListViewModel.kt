package com.cblanco.moviesapp.ui.movieslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cblanco.moviesapp.data.model.Movie
import com.cblanco.moviesapp.usecases.LoadMovies
import kotlinx.coroutines.launch
import javax.inject.Inject

class MoviesListViewModel @Inject constructor(private val loadMovies: LoadMovies) : ViewModel() {

    private val _progressBar = MutableLiveData<Boolean>()
    val progressBar: LiveData<Boolean> = _progressBar

    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> = _movies

    fun getPopularMovies(){
        viewModelScope.launch {
            _movies.value = loadMovies.getPopularMovies()
        }
    }


}