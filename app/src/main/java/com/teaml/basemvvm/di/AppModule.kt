package com.teaml.basemvvm.di

import android.content.Context
import com.teaml.basemvvm.App
import com.teaml.basemvvm.data.AppDataRepository
import com.teaml.basemvvm.data.DataRepository
import com.teaml.basemvvm.util.rx.AppSchedulerProvider
import com.teaml.basemvvm.util.rx.SchedulerProvider
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideContext(application: App): Context {
        return application.applicationContext
    }

    @Provides
    fun provideDataRepository(): DataRepository {
        return AppDataRepository()
    }

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }
}