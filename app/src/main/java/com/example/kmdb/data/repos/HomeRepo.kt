package com.example.kmdb.data.repos

import com.example.kmdb.data.models.SearchResults
import com.example.kmdb.data.network.ApiInterface
import com.example.kmdb.data.network.SafeApiRequest

class HomeRepo(
    private val api: ApiInterface
) : SafeApiRequest() {

    suspend fun getMovies(
        searchTitle: String,
        apiKey: String,
        pageIndex: Int
    ): SearchResults {

        return apiRequest { api.getSearchResultData(searchTitle, apiKey, pageIndex) }
    }
}