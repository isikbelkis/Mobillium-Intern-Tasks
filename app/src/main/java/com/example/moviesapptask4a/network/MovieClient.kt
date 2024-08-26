package com.example.moviesapptask4a.network

import com.example.moviesapptask4a.util.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieClient {

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(TokenInterceptor())
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val movieService = retrofit.create(MovieService::class.java)
}

