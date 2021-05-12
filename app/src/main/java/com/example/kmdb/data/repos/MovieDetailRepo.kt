package com.example.kmdb.data.repos

import com.example.kmdb.data.models.MovieDetail
import com.example.kmdb.data.network.ApiInterface
import com.example.kmdb.data.network.SafeApiRequest

class MovieDetailRepo(
    private val api: ApiInterface
) : SafeApiRequest() {

    suspend fun getMovieDetail(
        title: String,
        apiKey: String
    ): MovieDetail {

        return apiRequest { api.getMovieDetailData(title, apiKey) }
    }
}