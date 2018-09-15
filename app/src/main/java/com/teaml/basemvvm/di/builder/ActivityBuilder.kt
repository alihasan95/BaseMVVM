package com.teaml.basemvvm.di.builder

import com.teaml.basemvvm.ui.main.MainActivity
import com.teaml.basemvvm.ui.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * ContributesAndroidInjector : annotation helps Dagger to wire up what is needed
 * so we can inject instances in the specified activity.
 */

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityModule::class, FragmentBuilder::class])
    abstract fun provideMainActivity(): MainActivity

}