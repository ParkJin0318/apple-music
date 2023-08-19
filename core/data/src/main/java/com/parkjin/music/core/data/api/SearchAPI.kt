package com.parkjin.music.core.data.api

import com.parkjin.music.core.data.api.response.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchAPI {

    @GET("search")
    suspend fun search(
        @Query("term") term: String,
        @Query("entity") entity: String,
    ): List<SearchResponse>
}
