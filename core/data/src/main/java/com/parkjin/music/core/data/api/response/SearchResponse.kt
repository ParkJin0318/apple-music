package com.parkjin.music.core.data.api.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponse<T>(
    @SerialName("resultCount")
    val resultCount: Int,
    @SerialName("results")
    val results: List<T>,
)
