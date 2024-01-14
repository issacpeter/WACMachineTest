package com.example.wacmachinetest.model

data class HomeDataEntityItem(
    val contents: List<Content>,
    val id: String,
    val image_url: String,
    val title: String,
    val type: String
)