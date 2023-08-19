package com.parkjin.music.feature.archive

import com.parkjin.music.core.domain.model.Content

data class ArchiveUIState(
    val isLoading: Boolean = false,
    val tracks: List<Content> = emptyList(),
)
