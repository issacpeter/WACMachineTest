package com.example.wacmachinetest.data.di

import com.example.wacmachinetest.data.remote.HomeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHomeApi(): HomeApi{
        return Retrofit.Builder()
            .baseUrl("https://64bfc2a60d8e251fd111630f.mockapi.io/api/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(
                OkHttpClient.Builder().addInterceptor(
                    HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
                ).build()
            )
            .build()
            .create()
    }

}