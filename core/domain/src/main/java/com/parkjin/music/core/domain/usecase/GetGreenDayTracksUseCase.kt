package com.parkjin.music.core.domain.usecase

import com.parkjin.music.core.domain.model.Content
import com.parkjin.music.core.domain.repository.ContentRepository
import javax.inject.Inject

class GetGreenDayTracksUseCase @Inject constructor(
    private val repository: ContentRepository,
) {

    suspend operator fun invoke(
        limit: Int,
        offset: Int,
    ): List<Content> {
        return repository.searchContents(
            term = "greenday",
            entity = "song",
            limit = limit,
            offset = offset,
        )
    }
}
