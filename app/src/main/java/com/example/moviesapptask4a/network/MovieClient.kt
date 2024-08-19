package com.example.moviesapptask4a.network

import com.example.moviesapptask4a.util.Constans
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieClient {

    private const val base_url=Constans.BASE_URL

    val movieService:MovieService by lazy {
        Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieService::class.java)
    }
}

