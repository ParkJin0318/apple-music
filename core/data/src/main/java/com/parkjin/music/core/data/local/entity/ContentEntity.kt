package com.parkjin.music.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.parkjin.music.core.domain.model.Content

@Entity(tableName = "content_table")
data class ContentEntity(
    @PrimaryKey
    val trackId: Long,
    val trackName: String,
    val artistName: String,
    val collectionName: String,
    val artworkUrl: String,
)

fun ContentEntity.toModel() = Content(
    trackId = trackId,
    trackName = trackName,
    artistName = artistName,
    collectionName = collectionName,
    artworkUrl = artworkUrl,
)

fun Content.toEntity() = ContentEntity(
    trackId = trackId,
    trackName = trackName,
    artistName = artistName,
    collectionName = collectionName,
    artworkUrl = artworkUrl,
)
