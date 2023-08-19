package com.parkjin.music.core.domain.model

data class Content(
    val trackId: Long,
    val trackName: String,
    val artistName: String,
    val collectionName: String,
    val artworkUrl: String,
    val isArchived: Boolean,
)
