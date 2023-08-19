package com.parkjin.music.core.domain.usecase

import com.parkjin.music.core.domain.model.Content
import com.parkjin.music.core.domain.repository.ContentRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetArchivedTracksUseCase @Inject constructor(
    private val repository: ContentRepository,
) {

    operator fun invoke(): Flow<List<Content>> {
        return repository.getArchivedContents()
    }
}
