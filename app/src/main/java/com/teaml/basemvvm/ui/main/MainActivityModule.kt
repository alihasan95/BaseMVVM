package com.teaml.basemvvm.ui.main

import androidx.lifecycle.ViewModelProvider
import com.teaml.basemvvm.data.DataRepository
import com.teaml.basemvvm.util.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import com.teaml.basemvvm.ViewModelProviderFactory



@Module
class MainActivityModule {

    @Provides
    fun mainViewModelProvider(mainViewModel: MainViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(mainViewModel)
    }

    @Provides
    fun provideMainViewModel(dataRepository: DataRepository,schedulerProvider: SchedulerProvider): MainViewModel {
        return MainViewModel(dataRepository, schedulerProvider)
    }

}