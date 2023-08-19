package com.parkjin.music.feature.listening

import com.parkjin.music.core.domain.model.Content

data class ListeningUIState(
    val isLoading: Boolean = false,
    val tracks: List<Content> = emptyList(),
)
