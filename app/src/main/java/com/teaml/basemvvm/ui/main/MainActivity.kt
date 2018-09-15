package com.teaml.basemvvm.ui.main

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.teaml.basemvvm.BR
import com.teaml.basemvvm.R
import com.teaml.basemvvm.base.BaseActivity
import com.teaml.basemvvm.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity: BaseActivity<ActivityMainBinding, MainViewModel>() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var mainViewModel: MainViewModel
    lateinit var navController: NavController

    override fun getViewModel(): MainViewModel {
        return ViewModelProviders.of(this, viewModelFactory)
                .get(MainViewModel::class.java).also { mainViewModel = it }

    }

    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun setup() {
        navController = findNavController(this, R.id.navHost)
        with(viewDataBinding) {
            setSupportActionBar(toolbar)
            setupActionBarWithNavController(navController, drawerLayout)
            NavigationUI.setupWithNavController(navigationView, navController)

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(drawerLayout, navController)
    }
}