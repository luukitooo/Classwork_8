package com.example.classwork_8.data.remote.api

import com.example.classwork_8.common.constants.OutfitsApiUtil
import com.example.classwork_8.data.remote.dto.OutfitDto
import retrofit2.Response
import retrofit2.http.GET

interface OutfitsApi {

    @GET(OutfitsApiUtil.ENDPOINT_OUTFITS)
    suspend fun getOutfits(): Response<List<OutfitDto>>

}