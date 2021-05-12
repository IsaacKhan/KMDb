package com.example.kmdb.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kmdb.data.repos.HomeRepo

@Suppress("UNCHECKED_CAST")
class HomeViewModelFactory(
    private val repository: HomeRepo
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(repository) as T
    }
}