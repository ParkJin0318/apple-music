package com.parkjin.music.core.data.repository

import com.parkjin.music.core.data.api.SearchApi
import com.parkjin.music.core.data.api.response.toModel
import com.parkjin.music.core.domain.model.Media
import com.parkjin.music.core.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val api: SearchApi,
) : SearchRepository {

    override suspend fun search(
        term: String,
        entity: String,
        limit: Int,
        offset: Int,
    ): List<Media> {
        return api.search(term, entity, limit, offset)
            .results
            .map { it.toModel() }
    }
}
