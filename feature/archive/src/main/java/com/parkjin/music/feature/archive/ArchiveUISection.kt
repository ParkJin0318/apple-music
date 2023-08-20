package com.parkjin.music.feature.archive

import com.parkjin.music.core.domain.model.Content

sealed interface ArchiveUISection {

    val id: String

    object Header : ArchiveUISection {
        override val id: String = hashCode().toString()
    }

    object Empty : ArchiveUISection {
        override val id: String = hashCode().toString()
    }

    data class TrackItem(val track: Content) : ArchiveUISection {
        override val id: String = track.trackId.toString()
    }
}
