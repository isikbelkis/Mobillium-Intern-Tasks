package com.example.moviesapptask4a.model


import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results")
    val moviesItem: List<MoviesItem>
)