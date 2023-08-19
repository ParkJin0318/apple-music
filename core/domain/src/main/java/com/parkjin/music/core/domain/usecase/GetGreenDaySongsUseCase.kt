package com.parkjin.music.core.domain.usecase

import com.parkjin.music.core.domain.model.Media
import com.parkjin.music.core.domain.repository.SearchRepository
import javax.inject.Inject

class GetGreenDaySongsUseCase @Inject constructor(
    private val repository: SearchRepository,
) {

    suspend fun invoke(
        limit: Int,
        offset: Int,
    ): List<Media> {
        return repository.search(
            term = "greenday",
            entity = "song",
            limit = limit,
            offset = offset,
        )
    }
}
