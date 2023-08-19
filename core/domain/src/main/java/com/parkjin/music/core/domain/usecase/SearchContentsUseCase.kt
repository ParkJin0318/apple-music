package com.parkjin.music.core.domain.usecase

import com.parkjin.music.core.domain.model.Content
import com.parkjin.music.core.domain.repository.ContentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchContentsUseCase @Inject constructor(
    private val repository: ContentRepository,
) {

    operator fun invoke(
        term: String,
        entity: String,
        limit: Int,
        offset: Int,
    ): Flow<List<Content>> {
        return flow { emit(repository.searchContents(term, entity, limit, offset)) }
            .combine(repository.getArchivedContents()) { searchContents, archivedContents ->
                searchContents.map { user ->
                    val isArchived = archivedContents.map { it.trackId }.contains(user.trackId)
                    user.copy(isArchived = isArchived)
                }
            }
    }
}
