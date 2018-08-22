package com.teaml.basemvvm.ui.main.home

import androidx.lifecycle.ViewModelProvider
import com.teaml.basemvvm.ViewModelProviderFactory
import com.teaml.basemvvm.ui.main.MainViewModel
import dagger.Module
import dagger.Provides


@Module
class HomeFragmentModule {
    @Provides
    fun mainViewModelProvider(homeViewModel: HomeViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(homeViewModel)
    }
    @Provides
    fun provideHomeViewModel(): HomeViewModel {
        return HomeViewModel()
    }

}