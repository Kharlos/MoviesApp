package com.cblanco.moviesapp.data

import com.cblanco.moviesapp.data.datasources.RemoteDataSource
import com.cblanco.moviesapp.data.repository.MovieRepository
import com.cblanco.moviesapp.di.MainActivityComponent
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton


@Module
class DataModule {

    @Provides
    @Singleton
    fun movieRepositoryProvider(
        remoteDataSource: RemoteDataSource,
        @Named("apiKey") apikey: String
    )
            : MovieRepository = MovieRepository(remoteDataSource, apikey)

}