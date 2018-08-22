package com.teaml.basemvvm.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.teaml.basemvvm.R
import com.teaml.basemvvm.base.BaseFragment
import com.teaml.basemvvm.databinding.HomeFragmentBinding
import javax.inject.Inject

class HomeFragment : BaseFragment<HomeFragmentBinding, HomeViewModel>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var homeViewModel: HomeViewModel
    lateinit var homeDataBinding: HomeFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.home_fragment
    }

    override fun getViewModel(): HomeViewModel {
        return ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
                .also { homeViewModel = it } }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //homeDataBinding = getViewDataBinding()
    }

}