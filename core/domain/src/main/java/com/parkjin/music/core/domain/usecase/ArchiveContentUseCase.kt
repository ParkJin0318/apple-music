package com.parkjin.music.core.domain.usecase

import com.parkjin.music.core.domain.model.Content
import com.parkjin.music.core.domain.repository.ContentRepository
import javax.inject.Inject

class ArchiveContentUseCase @Inject constructor(
    private val repository: ContentRepository,
) {

    suspend operator fun invoke(content: Content) {
        repository.archiveContent(content)
    }
}
