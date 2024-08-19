package com.example.moviesapptask4a.model


import com.google.gson.annotations.SerializedName

data class ActorsResponse(
    @SerializedName("cast")
    val cast: List<Cast?>?
)