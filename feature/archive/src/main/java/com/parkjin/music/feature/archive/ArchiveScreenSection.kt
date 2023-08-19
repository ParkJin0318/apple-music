package com.parkjin.music.feature.archive

import com.parkjin.music.core.domain.model.Content

sealed interface ArchiveScreenSection {

    val id: String

    object Header : ArchiveScreenSection {
        override val id: String = hashCode().toString()
    }

    object Empty : ArchiveScreenSection {
        override val id: String = hashCode().toString()
    }

    data class TrackItem(val track: Content) : ArchiveScreenSection {
        override val id: String = track.trackId.toString()
    }
}
