package com.example.wacmachinetest.data.dto

import com.example.wacmachinetest.domain.model.HomeData

class HomeDataDTO : ArrayList<HomeDataItemDTO>()

fun HomeDataDTO.toDomain() = HomeData()