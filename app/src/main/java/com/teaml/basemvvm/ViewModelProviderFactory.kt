package com.teaml.basemvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelProviderFactory<V : ViewModel>(val viewModel: V) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            with(modelClass) {
                when {
                    isAssignableFrom(viewModel::class.java) ->
                        viewModel
                    else ->
                        throw IllegalArgumentException("Unknown viewModel class")
                }
            } as T

}