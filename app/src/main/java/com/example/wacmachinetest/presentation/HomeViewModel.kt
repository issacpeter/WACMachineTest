package com.example.wacmachinetest.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wacmachinetest.domain.repository.HomeRepository
import com.example.wacmachinetest.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
): ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    fun loadHomeData(){
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            when(val result = repository.getHomeData()){
                is Resource.Success -> {
                    state = state.copy(
                        homeData = result.data,
                        isLoading = false,
                        error = null
                    )
                }
                is Resource.Error -> {
                    state = state.copy(
                        homeData = null,
                        isLoading = false,
                        error = result.message
                    )
                }
            }
        }
    }
}