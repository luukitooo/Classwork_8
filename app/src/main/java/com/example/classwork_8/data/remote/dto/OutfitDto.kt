package com.example.classwork_8.data.remote.dto

import com.example.classwork_8.domain.model.Outfit

data class OutfitDto(
    val title: String?,
    val cover: String?,
    val price: String?,
    val liked: Boolean?
) {

    fun toOutfit() = Outfit(
        title = title,
        cover = cover,
        price = price,
        liked = liked
    )

}