package com.teaml.basemvvm.ui.main

import com.teaml.basemvvm.ui.base.BaseViewModel
import com.teaml.basemvvm.data.repository.DataRepository
import com.teaml.basemvvm.util.rx.SchedulerProvider
import javax.inject.Inject

class MainViewModel @Inject constructor(
        val dataRepository: DataRepository,
        valschedulerProvider: SchedulerProvider)
    : BaseViewModel() {


}