package com.example.moviesapptask4a.network

import com.example.moviesapptask4a.model.ActorsResponse
import com.example.moviesapptask4a.model.MovieDetailResponse
import com.example.moviesapptask4a.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface MovieService {

    @GET("now_playing")
    suspend fun getMoviesPopularList(@Header("Authorization") token: String): Response<MovieResponse>

    @GET("top_rated")
    suspend fun getMoviesTopRatedList(@Header("Authorization") token: String): Response<MovieResponse>

    @GET("upcoming")
    suspend fun getMoviesUpcomingList(@Header("Authorization") token: String): Response<MovieResponse>

    @GET("{movieId}")
    suspend fun getMovieDetail(@Path("movieId") movieId:String,@Header("Authorization") token: String) :Response<MovieDetailResponse>

    @GET("{movieId}/credits")
    suspend fun getMovieActors(@Path("movieId") movieId: String, @Header("Authorization") token: String): Response<ActorsResponse>

}