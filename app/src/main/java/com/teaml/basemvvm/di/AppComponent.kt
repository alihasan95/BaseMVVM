package com.teaml.basemvvm.di

import com.teaml.basemvvm.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * AndroidSupportInjectionModule : module that helps us to inject instances into
 * Activities, Fragments...
 *
 * AndroidInjector :  When we want to build our Component, we will need to use an instance
 * of App class as argument
 * The instance of App will be provided to all other @Provides methods in modules used in AppComponent.
 *
 * Builder class :  create AndroidInjector instance of type App in this case.
 */

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityBuilder::class])
interface AppComponent : AndroidInjector<App>{


    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()

}