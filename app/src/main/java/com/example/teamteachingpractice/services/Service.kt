package com.example.teamteachingpractice.services

import com.example.teamteachingpractice.data.Character
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    @GET("characters")
    suspend fun getCharacters(): List<Character>
}

object RetrofitInstance {
    private const val BASE_URL = "https://stranger-things-api.fly.dev/api/v1/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getRetrofitService(): RetrofitService {
        return retrofit.create(RetrofitService::class.java)
    }
}