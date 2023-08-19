package com.parkjin.music.feature.listening

import com.parkjin.music.core.domain.model.Media

data class ListeningUIState(
    val isLoading: Boolean = false,
    val songs: List<Media> = emptyList(),
)
