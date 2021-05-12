package com.example.kmdb

import android.app.Application
import com.example.kmdb.data.network.ApiInterface
import com.example.kmdb.data.network.NetworkConnectionInterceptor
import com.example.kmdb.data.repos.HomeRepo
import com.example.kmdb.data.repos.MovieDetailRepo
import com.example.kmdb.ui.home.HomeViewModelFactory
import com.example.kmdb.ui.moviedetail.MovieDetailViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class KMDBApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@KMDBApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { ApiInterface(instance()) }
        bind() from singleton { HomeRepo(instance()) }
        bind() from provider { HomeViewModelFactory(instance()) }
        bind() from singleton { MovieDetailRepo(instance()) }
        bind() from provider { MovieDetailViewModelFactory(instance()) }
    }
}