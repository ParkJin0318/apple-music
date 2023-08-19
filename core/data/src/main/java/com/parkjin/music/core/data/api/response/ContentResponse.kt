package com.parkjin.music.core.data.api.response

import com.parkjin.music.core.domain.model.Content
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContentResponse(
    @SerialName("trackId")
    val trackId: Long,
    @SerialName("trackName")
    val trackName: String,
    @SerialName("artistName")
    val artistName: String,
    @SerialName("collectionName")
    val collectionName: String,
    @SerialName("artworkUrl60")
    val artworkUrl: String,
)

fun ContentResponse.toModel() = Content(
    trackId = trackId,
    trackName = trackName,
    artistName = artistName,
    collectionName = collectionName,
    artworkUrl = artworkUrl,
    isArchive = false,
)
