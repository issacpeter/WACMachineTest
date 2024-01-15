package com.example.wacmachinetest.data.dto

import com.example.wacmachinetest.domain.model.Content
import com.squareup.moshi.Json

data class ContentDTO(
    @field:Json(name = "actual_price")
    val actual_price: String? = null,
    @field:Json(name = "discount")
    val discount: String? = null,
    @field:Json(name = "image_url")
    val image_url: String? = null,
    @field:Json(name = "offer_price")
    val offer_price: String? = null,
    @field:Json(name = "product_image")
    val product_image: String? = null,
    @field:Json(name = "product_name")
    val product_name: String? = null,
    @field:Json(name = "product_rating")
    val product_rating: Int? = null,
    @field:Json(name = "sku")
    val sku: String? = null,
    @field:Json(name = "title")
    val title: String? = null
)

fun ContentDTO.toDomain() = Content(
    actual_price = actual_price.orEmpty(),
    discount = discount.orEmpty(),
    image_url = image_url.orEmpty(),
    offer_price = offer_price.orEmpty(),
    product_image = product_image.orEmpty(),
    product_name = product_name.orEmpty(),
    product_rating = product_rating?:0,
    sku = sku.orEmpty(),
    title = title.orEmpty()
)