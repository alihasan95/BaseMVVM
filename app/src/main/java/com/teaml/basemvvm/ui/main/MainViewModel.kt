package com.teaml.basemvvm.ui.main

import androidx.lifecycle.MutableLiveData
import com.teaml.basemvvm.base.BaseViewModel
import com.teaml.basemvvm.data.DataRepository
import com.teaml.basemvvm.util.rx.SchedulerProvider
import javax.inject.Inject

class MainViewModel @Inject constructor(dataRepository: DataRepository, schedulerProvider: SchedulerProvider)
    : BaseViewModel() {


}