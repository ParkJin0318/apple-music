package com.parkjin.music.feature.listening

import com.parkjin.music.core.domain.model.Content

sealed interface ListeningScreenSection {

    val id: String

    object Header : ListeningScreenSection {
        override val id: String = hashCode().toString()
    }

    object Empty : ListeningScreenSection {
        override val id: String = hashCode().toString()
    }

    data class TrackItem(val track: Content) : ListeningScreenSection {
        override val id: String = track.trackId.toString()
    }
}
