package com.parkjin.music.feature.play

import com.parkjin.music.core.domain.model.Media

data class PlayState(
    val isLoading: Boolean = false,
    val songs: List<Media> = emptyList(),
)
