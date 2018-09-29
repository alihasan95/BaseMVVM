package com.teaml.basemvvm.ui.main.home

import com.teaml.basemvvm.ui.base.BaseViewModel
import com.teaml.basemvvm.data.repository.DataRepository
import com.teaml.basemvvm.util.rx.SchedulerProvider
import javax.inject.Inject

class HomeViewModel @Inject constructor(
        val dataRepository: DataRepository,
        val schedulerProvider: SchedulerProvider)
    : BaseViewModel() {

}
