package com.example.wacmachinetest.data.dto

import com.example.wacmachinetest.domain.model.Content
import com.squareup.moshi.Json

data class ContentDTO(
    @field:Json(name = "actual_price")
    val actualPrice: String? = null,
    @field:Json(name = "discount")
    val discount: String? = null,
    @field:Json(name = "image_url")
    val imageUrl: String? = null,
    @field:Json(name = "offer_price")
    val offerPrice: String? = null,
    @field:Json(name = "product_image")
    val productImage: String? = null,
    @field:Json(name = "product_name")
    val productName: String? = null,
    @field:Json(name = "product_rating")
    val productRating: Int? = null,
    @field:Json(name = "sku")
    val sku: String? = null,
    @field:Json(name = "title")
    val title: String? = null
)

fun ContentDTO.toDomain() = Content(
    actual_price = actualPrice.orEmpty(),
    discount = discount.orEmpty(),
    image_url = imageUrl.orEmpty(),
    offer_price = offerPrice.orEmpty(),
    product_image = productImage.orEmpty(),
    product_name = productName.orEmpty(),
    product_rating = productRating?:0,
    sku = sku.orEmpty(),
    title = title.orEmpty()
)