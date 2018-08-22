package com.teaml.basemvvm.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerFragment

abstract class BaseFragment<VD : ViewDataBinding, VM : BaseViewModel> : DaggerFragment() {

    lateinit var baseActivity: BaseActivity<VD, VM>
    private var dataBinding: VD? = null
    private var viewModel: VM? = null

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    abstract fun getBindingVariable(): Int

    /**
     * @return layout resource id
     */
    abstract fun getLayoutId(): Int

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    abstract fun getViewModel(): VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getViewModel()
        setHasOptionsMenu(false)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        return dataBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding?.setVariable(getBindingVariable(), viewModel)
        dataBinding?.executePendingBindings()
    }

    fun getViewDataBinding(): VD {
        return dataBinding!!
    }
    interface Callback {

        fun onFragmentAttached()

        fun onFragmentDetached(tag: String)
    }
}