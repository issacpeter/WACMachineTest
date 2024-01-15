package com.example.wacmachinetest.data.repository

import com.example.wacmachinetest.data.dto.toDomain
import com.example.wacmachinetest.data.remote.HomeApi
import com.example.wacmachinetest.domain.model.HomeData
import com.example.wacmachinetest.domain.model.HomeDataItem
import com.example.wacmachinetest.domain.repository.HomeRepository
import com.example.wacmachinetest.domain.util.Resource
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeApi: HomeApi
): HomeRepository {
    override suspend fun getHomeData(): Resource<List<HomeDataItem>> {
        return try {
            Resource.Success(
                data = homeApi.getHomeData().map {
                    it.toDomain()
                }
            )
        } catch (e: Exception){
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}