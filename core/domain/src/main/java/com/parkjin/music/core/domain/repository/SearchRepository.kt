package com.parkjin.music.core.domain.repository

import com.parkjin.music.core.domain.model.Media

interface SearchRepository {

    suspend fun search(
        term: String,
        entity: String,
        limit: Int,
        offset: Int,
    ): List<Media>
}
