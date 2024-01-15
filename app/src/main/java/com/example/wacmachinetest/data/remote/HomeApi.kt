package com.example.wacmachinetest.data.remote

import com.example.wacmachinetest.data.dto.HomeDataDTO
import com.example.wacmachinetest.data.dto.HomeDataItemDTO
import retrofit2.http.GET

interface HomeApi {

    @GET("Todo")
    suspend fun getHomeData(): List<HomeDataItemDTO>
}