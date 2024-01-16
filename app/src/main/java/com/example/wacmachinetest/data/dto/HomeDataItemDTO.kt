package com.example.wacmachinetest.data.dto

import com.example.wacmachinetest.domain.model.HomeDataItem
import com.example.wacmachinetest.domain.model.HomeItemType
import com.squareup.moshi.Json

data class HomeDataItemDTO(
    @field:Json(name = "contents")
    val contentDTO: List<ContentDTO>? = emptyList(),
    @field:Json(name = "id")
    val id: String? = null,
    @field:Json(name = "image_url")
    val image_url: String? = null,
    @field:Json(name = "title")
    val title: String? = null,
    @field:Json(name = "type")
    val type: String
)

fun HomeDataItemDTO.toDomain() = HomeDataItem(
    contents = contentDTO.orEmpty().map { it.toDomain() },
    id = id.orEmpty(),
    imageUrl = image_url.orEmpty(),
    title = title.orEmpty(),
    type = when(type){
        "banner_slider" -> HomeItemType.BANNER_SLIDER
        "products" -> HomeItemType.PRODUCTS
        "banner_single" -> HomeItemType.BANNER_SINGLE
        "catagories" -> HomeItemType.CATEGORIES
        else -> null
    }
)

