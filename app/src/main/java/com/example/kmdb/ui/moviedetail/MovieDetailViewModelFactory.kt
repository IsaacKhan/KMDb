package com.example.kmdb.ui.moviedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kmdb.data.repos.MovieDetailRepo

@Suppress("UNCHECKED_CAST")
class MovieDetailViewModelFactory(
    private val repository: MovieDetailRepo
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieDetailViewModel(repository) as T
    }
}