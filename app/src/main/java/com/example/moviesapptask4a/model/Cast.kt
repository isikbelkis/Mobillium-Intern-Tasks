package com.example.moviesapptask4a.model


import com.google.gson.annotations.SerializedName

data class Cast(
    @SerializedName("name")
    val name: String?,
    @SerializedName("profile_path")
    val profilePath: String?
)