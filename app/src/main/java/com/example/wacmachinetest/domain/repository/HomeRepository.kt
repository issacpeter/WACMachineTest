package com.example.wacmachinetest.domain.repository

import com.example.wacmachinetest.domain.model.HomeData
import com.example.wacmachinetest.domain.model.HomeDataItem
import com.example.wacmachinetest.domain.util.Resource

interface HomeRepository {
    suspend fun getHomeData(): Resource<List<HomeDataItem>>
}