package com.parkjin.music.feature.listening

data class ListeningUIState(
    val offset: Int = 0,
    val sections: List<ListeningUISection> = emptyList(),
)
