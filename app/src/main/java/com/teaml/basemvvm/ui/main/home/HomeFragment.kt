package com.teaml.basemvvm.ui.main.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.teaml.basemvvm.R
import com.teaml.basemvvm.base.BaseFragment
import com.teaml.basemvvm.databinding.HomeFragmentBinding
import kotlinx.android.synthetic.main.home_fragment.*
import org.jetbrains.anko.toast
import javax.inject.Inject

class HomeFragment : BaseFragment<HomeFragmentBinding, HomeViewModel>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var homeViewModel: HomeViewModel
    lateinit var homeDataBinding: HomeFragmentBinding



    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.home_fragment
    }

    override fun getViewModel(): HomeViewModel {
        return ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
                .also { homeViewModel = it } }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeDataBinding = getViewDataBinding()
    }

}
