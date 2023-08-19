package com.parkjin.music.core.data.api.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchResponse(
    @SerialName("trackName")
    val trackName: String,
    @SerialName("artistName")
    val artistName: String,
    @SerialName("collectionName")
    val albumName: String,
    @SerialName("artworkUrl60")
    val artworkUrl: String,
)
