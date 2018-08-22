package com.teaml.basemvvm.ui.main.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.teaml.basemvvm.base.BaseViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor() : BaseViewModel() {

    val liveData = MutableLiveData<String>()

    init {
        setLiveData()
    }
    fun setLiveData() {
        liveData.value = "HELLO"
    }
    fun getliveData() = liveData
}
