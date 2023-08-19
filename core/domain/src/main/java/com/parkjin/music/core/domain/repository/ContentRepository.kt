package com.parkjin.music.core.domain.repository

import com.parkjin.music.core.domain.model.Content
import kotlinx.coroutines.flow.Flow

interface ContentRepository {

    suspend fun searchContents(
        term: String,
        entity: String,
        limit: Int,
        offset: Int,
    ): List<Content>

    fun getArchivedContents(): Flow<List<Content>>

    suspend fun archiveContent(content: Content)

    suspend fun unarchiveContent(content: Content)
}
