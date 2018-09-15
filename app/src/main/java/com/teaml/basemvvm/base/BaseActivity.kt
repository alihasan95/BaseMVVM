package com.teaml.basemvvm.base


import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import android.content.pm.PackageManager
import android.os.Build
import android.annotation.TargetApi
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v4.app.ActivityCompat.requestPermissions
import android.support.v4.content.PermissionChecker.checkSelfPermission


abstract class BaseActivity<VD : ViewDataBinding, VM : BaseViewModel> : DaggerAppCompatActivity() {

    private var viewModel: VM? = null
    lateinit var viewDataBinding: VD
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performViewDataBinding()
        setup()
    }

    /**
     * override to set viewModel
     * @return instance of viewModel
     */
    abstract fun getViewModel(): VM

    /**
     * override to set layout resource for this activity
     */
    @LayoutRes
    abstract fun getLayoutRes(): Int

    /**
     * override to set activityEventBinding variable
     * @return variable id
     */
    abstract fun getBindingVariable(): Int


    abstract fun setup()


    private fun performViewDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutRes())
        viewModel = viewModel ?: getViewModel()
        viewDataBinding.setVariable(getBindingVariable(), viewModel)
        viewDataBinding.executePendingBindings()
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
}