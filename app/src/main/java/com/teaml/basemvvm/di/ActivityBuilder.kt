package com.teaml.basemvvm.di

import androidx.lifecycle.ViewModel
import com.teaml.basemvvm.di.annotation.ViewModelKey
import com.teaml.basemvvm.ui.main.MainActivity
import com.teaml.basemvvm.ui.main.MainActivityModule
import com.teaml.basemvvm.ui.main.MainViewModel
import com.teaml.basemvvm.ui.main.home.HomeFragment
import com.teaml.basemvvm.ui.main.home.HomeFragmentModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * ContributesAndroidInjector : annotation helps Dagger to wire up what is needed
 * so we can inject instances in the specified activity.
 */

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun provideMainActivity(): MainActivity

}