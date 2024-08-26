package com.example.moviesapptask4a.network

import com.example.moviesapptask4a.util.Constants
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val token = Constants.BEARER_TOKEN

        val request = originalRequest.newBuilder()
            .header("Authorization", "BearerToken $token")
            .build()
        val response = chain.proceed(request)

        return response
    }
}