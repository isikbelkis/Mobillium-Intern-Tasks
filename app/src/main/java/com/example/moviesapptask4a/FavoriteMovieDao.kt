package com.example.moviesapptask4a

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviesapptask4a.model.FavoriteMovie

@Dao
interface FavoriteMovieDao {
    @Query("SELECT * FROM favorites")
    fun getAllFavoriteMovies(): LiveData<List<FavoriteMovie>>

    @Query("SELECT EXISTS(SELECT 1 FROM favorites WHERE id = :movieId)")
    fun isMovieFavorite(movieId: Int): LiveData<Boolean>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: FavoriteMovie)

    @Query("DELETE FROM favorites WHERE id = :movieId")
    suspend fun deleteMovie(movieId: Int) :Int
}