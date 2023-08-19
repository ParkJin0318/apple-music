package com.parkjin.music.core.data.repository

import com.parkjin.music.core.data.api.SearchApi
import com.parkjin.music.core.data.api.response.toModel
import com.parkjin.music.core.data.local.dao.ArchivedContentDao
import com.parkjin.music.core.data.local.entity.toEntity
import com.parkjin.music.core.data.local.entity.toModel
import com.parkjin.music.core.domain.model.Content
import com.parkjin.music.core.domain.repository.ContentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ContentRepositoryImpl @Inject constructor(
    private val api: SearchApi,
    private val dao: ArchivedContentDao,
) : ContentRepository {

    override suspend fun searchContents(
        term: String,
        entity: String,
        limit: Int,
        offset: Int,
    ): List<Content> {
        return api.search(term, entity, limit, offset)
            .results
            .map { it.toModel() }
    }

    override fun getArchivedContents(): Flow<List<Content>> {
        return dao.getContents().map { entities ->
            entities.map { it.toModel() }
        }
    }

    override suspend fun archiveContent(content: Content) {
        dao.insertContent(content.toEntity())
    }

    override suspend fun unarchiveContent(content: Content) {
        dao.deleteContent(content.toEntity())
    }
}
