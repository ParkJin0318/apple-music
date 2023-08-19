package com.parkjin.music.core.domain.usecase

import com.parkjin.music.core.domain.model.Content
import com.parkjin.music.core.domain.repository.SearchRepository
import javax.inject.Inject

class GetGreenDayTracksUseCase @Inject constructor(
    private val repository: SearchRepository,
) {

    suspend operator fun invoke(
        limit: Int,
        offset: Int,
    ): List<Content> {
        return repository.search(
            term = "greenday",
            entity = "song",
            limit = limit,
            offset = offset,
        )
    }
}
