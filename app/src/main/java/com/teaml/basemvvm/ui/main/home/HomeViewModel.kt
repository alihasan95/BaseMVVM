package com.teaml.basemvvm.ui.main.home

import androidx.annotation.MainThread
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.teaml.basemvvm.base.BaseViewModel
import com.teaml.basemvvm.data.AppDataRepository
import com.teaml.basemvvm.data.DataRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HomeViewModel @Inject constructor(val dataRepository: DataRepository) : BaseViewModel() {

}
