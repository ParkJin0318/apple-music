package com.parkjin.music.core.data.api.response

import com.parkjin.music.core.domain.model.Media
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MediaResponse(
    @SerialName("trackName")
    val trackName: String,
    @SerialName("artistName")
    val artistName: String,
    @SerialName("collectionName")
    val collectionName: String,
    @SerialName("artworkUrl60")
    val artworkUrl: String,
)

fun MediaResponse.toModel() = Media(
    trackName = trackName,
    artistName = artistName,
    collectionName = collectionName,
    artworkUrl = artworkUrl,
)
