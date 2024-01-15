package com.example.wacmachinetest.domain.model

data class HomeDataItem(
    val contents: List<Content>,
    val id: String,
    val imageUrl: String,
    val title: String,
    val type: HomeItemType?
)