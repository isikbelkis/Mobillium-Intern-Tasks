package com.example.moviesapptask4a.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class FavoriteMovie(
    @PrimaryKey(autoGenerate = true) val id: Int = 0 ,
    val title: String,
    val posterUrl: String
)