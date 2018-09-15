package com.teaml.basemvvm.di.module

import android.content.Context
import com.teaml.basemvvm.App
import com.teaml.basemvvm.data.AppDataRepository
import com.teaml.basemvvm.data.DataRepository
import com.teaml.basemvvm.util.rx.AppSchedulerProvider
import com.teaml.basemvvm.util.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: App): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideDataRepository(): DataRepository {
        return AppDataRepository()
    }

    @Provides
    @Singleton
    fun provideSchedulerProvider(): SchedulerProvider {
        return AppSchedulerProvider()
    }
}