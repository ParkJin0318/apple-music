package com.parkjin.music.feature.listening

import com.parkjin.music.core.domain.model.Content

sealed interface ListeningUISection {

    val id: String

    object Header : ListeningUISection {
        override val id: String = hashCode().toString()
    }

    object Empty : ListeningUISection {
        override val id: String = hashCode().toString()
    }

    data class TrackItem(val track: Content) : ListeningUISection {
        override val id: String = track.trackId.toString()
    }

    object Loading : ListeningUISection {
        override val id: String = hashCode().toString()
    }
}
