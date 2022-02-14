package com.priambudi19.pagingnormal.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieApiClient {
    private const val BASE_URL = "https://api.themoviedb.org/3/"
    const val API_KEY = "TMDB API HERE"
    private val builder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun getInstance(): MovieApiService = builder.create(MovieApiService::class.java)
}