package com.cblanco.moviesapp.di

import android.app.Application
import com.cblanco.moviesapp.MainApplication
import com.cblanco.moviesapp.data.DataModule
import com.cblanco.moviesapp.di.builder.framework.MainActivityBuilder
import com.cblanco.moviesapp.di.builder.framework.viewmodel.ViewModelBuilder
import com.cblanco.moviesapp.ui.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        DataModule::class,
        MainActivityBuilder::class,
        ViewModelBuilder::class
    ]
)
interface AppComponent: AndroidInjector<DaggerApplication> {

    fun inject(app: MainApplication)

    override fun inject(instance: DaggerApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}