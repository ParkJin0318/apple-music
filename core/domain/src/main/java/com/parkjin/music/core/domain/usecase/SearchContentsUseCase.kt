package com.parkjin.music.core.domain.usecase

import com.parkjin.music.core.domain.model.Content
import com.parkjin.music.core.domain.repository.ContentRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class SearchContentsUseCase @Inject constructor(
    private val repository: ContentRepository,
) {

    private val _data = MutableStateFlow<List<Content>>(emptyList())

    val data = _data.asSharedFlow()
        .combine(repository.getArchivedContents()) { searchContents, archivedContents ->
            searchContents.map { user ->
                val isArchived = archivedContents.map { it.trackId }.contains(user.trackId)
                user.copy(isArchived = isArchived)
            }
        }

    suspend operator fun invoke(
        term: String,
        entity: String,
        limit: Int,
        offset: Int,
    ) {
        _data.emit(
            repository.searchContents(term, entity, limit, offset),
        )
    }
}
