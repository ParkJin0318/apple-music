package com.parkjin.music.feature.listening

data class ListeningUIState(
    val isLoading: Boolean = false,
    val uiModels: List<ListeningUIModel> = emptyList(),
)
