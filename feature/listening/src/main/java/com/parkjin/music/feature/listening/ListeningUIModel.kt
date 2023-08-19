package com.parkjin.music.feature.listening

import com.parkjin.music.core.domain.model.Media

interface ListeningUIModel {

    object Header : ListeningUIModel

    data class Track(
        val item: Media,
        val addedToLocker: Boolean,
    ) : ListeningUIModel
}
