package com.cblanco.moviesapp.ui

import android.app.Application
import android.content.Context
import com.cblanco.moviesapp.data.datasources.RemoteDataSource
import com.cblanco.moviesapp.di.MainActivityComponent
import com.cblanco.moviesapp.ui.data.datasources.MovieRemoteService
import com.cblanco.moviesapp.ui.data.datasources.ServeMovieDataSource
import com.cblanco.moviesapp.util.RETROFIT_TIME_OUT
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton


@Module(subcomponents = [MainActivityComponent::class])
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    @Named("apiKey")
    fun apiKeyProvider(): String = "d282f241c20970cd18ce3bfdeced651d"

    @Provides
    @Singleton
    fun retrofitProvider(): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(RETROFIT_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(RETROFIT_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(RETROFIT_TIME_OUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build()
        )
        .build()

    @Provides
    @Singleton
    fun movieRemoteServiceProvider(retrofit: Retrofit): MovieRemoteService =
        retrofit.create(MovieRemoteService::class.java)

    @Provides
    fun remoteDataSourceProvider(movieRemoteService: MovieRemoteService): RemoteDataSource =
        ServeMovieDataSource(movieRemoteService)
}
