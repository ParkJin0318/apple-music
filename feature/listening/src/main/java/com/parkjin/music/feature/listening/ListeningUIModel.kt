package com.parkjin.music.feature.listening

import com.parkjin.music.core.domain.model.Content

interface ListeningUIModel {

    object Header : ListeningUIModel

    data class Track(
        val item: Content,
        val addedToStorage: Boolean,
    ) : ListeningUIModel
}
