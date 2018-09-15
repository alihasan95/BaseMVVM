package com.teaml.basemvvm

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

/*
* Map take two argument key(class type) and value(instance of class type)
*
* */

class DaggerViewModelFactory @Inject constructor(
        private val viewModelsMap: @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        val creator: Provider<out ViewModel>? = viewModelsMap[modelClass]
                ?:
                viewModelsMap.asIterable().firstOrNull {
                    modelClass.isAssignableFrom(it.key)
                }?.value
                ?:
                throw IllegalArgumentException("unknown model class $modelClass")

        /*
        var creator: Provider<out ViewModel>? = viewModelsMap[modelClass]
        if (creator == null) {
            for ((key, value) in viewModelsMap) {
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }
        if (creator == null) {
            throw IllegalArgumentException("unknown model class " + modelClass)
        }*/

        try {
            @Suppress("UNCHECKED_CAST")
            return creator?.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}