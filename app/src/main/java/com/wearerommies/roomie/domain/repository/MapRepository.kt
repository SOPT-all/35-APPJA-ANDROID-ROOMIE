package com.wearerommies.roomie.domain.repository

import com.wearerommies.roomie.domain.entity.SearchResultEntity

interface MapRepository {
    suspend fun getSearchResult(query:String):Result<List<SearchResultEntity>>
}
