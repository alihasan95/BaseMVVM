package com.teaml.basemvvm.di

import com.teaml.basemvvm.ui.main.MainActivity
import com.teaml.basemvvm.ui.main.MainActivityModule
import com.teaml.basemvvm.ui.main.home.HomeFragment
import com.teaml.basemvvm.ui.main.home.HomeFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * ContributesAndroidInjector : annotation helps Dagger to wire up what is needed
 * so we can inject instances in the specified activity.
 */

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun provideMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    abstract fun provideHomeFragment(): HomeFragment
}