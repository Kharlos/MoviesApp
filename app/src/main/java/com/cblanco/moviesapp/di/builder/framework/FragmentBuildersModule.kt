package com.cblanco.moviesapp.di.builder.framework

import com.cblanco.moviesapp.ui.moviedetail.MovieDetailFragment
import com.cblanco.moviesapp.ui.movieslist.MoviesListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Suppress("unused")
@Module
abstract class FragmentBuildersModule {


    @ContributesAndroidInjector(
        modules = [
            MovieListViewModelBuilder::class
        ]
    )
    abstract fun contibuteMovieListFragment(): MoviesListFragment

    @ContributesAndroidInjector(
        modules = [
            MovieDetailViewModelBuilder::class
        ]
    )
    abstract fun contibuteMovieDetailFragment(): MovieDetailFragment
}