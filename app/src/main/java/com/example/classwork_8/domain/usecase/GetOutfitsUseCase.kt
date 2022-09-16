package com.example.classwork_8.domain.usecase

import com.example.classwork_8.domain.repository.OutfitsRepository
import javax.inject.Inject

class GetOutfitsUseCase @Inject constructor(
    private val repository: OutfitsRepository
) {

    suspend operator fun invoke() = repository.getOutfits()

}