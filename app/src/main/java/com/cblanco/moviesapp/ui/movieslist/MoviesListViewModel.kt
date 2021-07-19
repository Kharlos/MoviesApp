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

    private val _filters = MutableLiveData<List<Movie>>()
    var filters: MutableLiveData<List<Movie>> = _filters

    fun getPopularMovies() {
        viewModelScope.launch {
            _progressBar.value = true
            _movies.value = loadMovies.getPopularMovies()
            _progressBar.value = false
        }
    }

    fun filterByName(query: String) {
        _movies.value?.let { list ->
            if (query.isNullOrBlank()) {
                _filters.value = list
            } else {
                _filters.value = list.filter { it.title?.contains(query, true) ?: false }
            }
        }
    }
}