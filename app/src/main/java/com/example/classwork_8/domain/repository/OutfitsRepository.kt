package com.example.classwork_8.domain.repository

import com.example.classwork_8.common.utils.Resource
import com.example.classwork_8.data.remote.dto.OutfitDto
import kotlinx.coroutines.flow.Flow

interface OutfitsRepository {

    suspend fun getOutfits() : Flow<Resource<List<OutfitDto>>>

}