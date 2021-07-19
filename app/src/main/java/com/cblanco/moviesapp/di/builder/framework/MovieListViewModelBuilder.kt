package com.cblanco.moviesapp.di.builder.framework

import androidx.lifecycle.ViewModel
import com.cblanco.moviesapp.di.ViewModelKey
import com.cblanco.moviesapp.ui.movieslist.MoviesListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
@Suppress("unused")
abstract class MovieListViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(MoviesListViewModel::class)
    internal abstract fun bindMoviesListViewModel(viewModel: MoviesListViewModel): ViewModel

}