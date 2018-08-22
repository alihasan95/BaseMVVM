package com.teaml.basemvvm.base


import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerAppCompatActivity


abstract class BaseActivity<VD : ViewDataBinding, VM : BaseViewModel> : DaggerAppCompatActivity() {


    private var mViewModel: VM? = null
    private lateinit var mViewDataBinding: VD

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performViewDataBinding()
    }

    /**
     * override to set viewModel
     * @return instance of viewModel
     */
    abstract fun getViewModel(): VM

    /**
     * override to set layout resource for this activity
     */
    abstract fun getLayoutRes(): Int

    /**
     * override to set activityEventBinding variable
     * @return variable id
     */
    abstract fun getBindingVariable(): Int


    private fun performViewDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutRes())
        mViewModel = mViewModel ?: getViewModel()
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel)
        mViewDataBinding.executePendingBindings()
    }

    /**
     * @return instance of viewDataBinding associated with this activity
     */
    fun getViewDataBinding(): VD {
        return mViewDataBinding
    }

}