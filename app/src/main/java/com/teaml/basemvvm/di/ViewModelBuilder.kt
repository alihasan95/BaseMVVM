package com.teaml.basemvvm.di

import androidx.lifecycle.ViewModelProvider
import com.teaml.basemvvm.DaggerViewModelFactory
import dagger.Binds
import dagger.Module


@Module
abstract class ViewModelBuilder {

    @Binds
    abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory

}