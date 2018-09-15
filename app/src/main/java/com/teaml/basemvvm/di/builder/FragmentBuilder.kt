package com.teaml.basemvvm.di.builder

import com.teaml.basemvvm.ui.main.home.HomeFragment
import com.teaml.basemvvm.ui.main.home.HomeFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    abstract fun bindHomeFragment(): HomeFragment

}