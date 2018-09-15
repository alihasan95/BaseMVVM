package com.teaml.basemvvm.ui.main.home

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import com.teaml.basemvvm.BR
import com.teaml.basemvvm.R
import com.teaml.basemvvm.base.BaseFragment
import com.teaml.basemvvm.databinding.HomeFragmentBinding
import javax.inject.Inject

class HomeFragment : BaseFragment<HomeFragmentBinding, HomeViewModel>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var homeViewModel: HomeViewModel


    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.home_fragment
    }

    override fun getViewModel(): HomeViewModel {
        return ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
                .also { homeViewModel = it } }



}
