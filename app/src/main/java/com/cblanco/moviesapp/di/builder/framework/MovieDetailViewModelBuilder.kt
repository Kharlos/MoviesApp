package com.cblanco.moviesapp.di.builder.framework

import androidx.lifecycle.ViewModel
import com.cblanco.moviesapp.di.ViewModelKey
import com.cblanco.moviesapp.ui.moviedetail.MovieDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
@Suppress("unused")
abstract class MovieDetailViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(MovieDetailViewModel::class)
    internal abstract fun bindMovieDetailViewModel(viewModel: MovieDetailViewModel): ViewModel

}