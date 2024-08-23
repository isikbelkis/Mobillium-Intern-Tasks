package com.example.moviesapptask4a

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviesapptask4a.model.FavoriteMovie

class FavoriteMovieRepository(private val favoriteMovieDao: FavoriteMovieDao) {
    fun getAllFavoriteMovies(): LiveData<List<FavoriteMovie>> {
        return favoriteMovieDao.getAllFavoriteMovies()
    }

    fun isMovieFavorite(movieId: Int): LiveData<Boolean> {
        return favoriteMovieDao.isMovieFavorite(movieId)
    }

    suspend fun insertMovie(movie: FavoriteMovie) {
        favoriteMovieDao.insertMovie(movie)
    }

    suspend fun deleteMovie(movieId: Int) {
        favoriteMovieDao.deleteMovie(movieId)
    }

}