package com.teaml.basemvvm.base


import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerAppCompatActivity
import android.content.pm.PackageManager
import android.os.Build
import android.annotation.TargetApi




abstract class BaseActivity<VD : ViewDataBinding, VM : BaseViewModel> : DaggerAppCompatActivity()
, BaseFragment.Callback{


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

    /**
    *  request permission
    *  */

    @TargetApi(Build.VERSION_CODES.M)
    fun hasPermission(permission: String): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun requestPermissionsSafely(permissions: Array<String>, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode)
        }
    }

    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String) {

    }

}