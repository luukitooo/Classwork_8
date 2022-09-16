package com.example.classwork_8.data.repository

import com.example.classwork_8.common.utils.RequestHandler
import com.example.classwork_8.common.utils.Resource
import com.example.classwork_8.data.remote.api.OutfitsApi
import com.example.classwork_8.data.remote.dto.OutfitDto
import com.example.classwork_8.domain.repository.OutfitsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class OutfitsRepositoryImpl @Inject constructor(
    private val api: OutfitsApi
) : OutfitsRepository, RequestHandler {

    override suspend fun getOutfits(): Flow<Resource<List<OutfitDto>>> {
        return safeApiCall { api.getOutfits() }
    }

}