package com.example.wacmachinetest.presentation

import com.example.wacmachinetest.domain.model.HomeData
import com.example.wacmachinetest.domain.model.HomeDataItem

data class HomeState(
    val homeData: List<HomeDataItem>? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
