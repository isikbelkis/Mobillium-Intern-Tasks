package com.example.moviesapptask4a.network

import com.example.moviesapptask4a.util.Constans
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieClient {
    fun getClient(): MovieService {
        return Retrofit.Builder().baseUrl(Constans.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieService::class.java)
    }
}

