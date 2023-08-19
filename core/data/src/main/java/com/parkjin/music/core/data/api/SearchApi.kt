package com.parkjin.music.core.data.api

import com.parkjin.music.core.data.api.response.SearchResponse
import com.parkjin.music.core.data.api.response.MediaResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApi {

    @GET("search")
    suspend fun search(
        @Query("term") term: String,
        @Query("entity") entity: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): SearchResponse<MediaResponse>
}
