package com.cblanco.moviesapp.di.builder.framework

import com.cblanco.moviesapp.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityBuilder {

    @ContributesAndroidInjector(
        modules = [
            FragmentBuildersModule::class
        ]
    )

    internal abstract fun bindMainActivity(): MainActivity

}