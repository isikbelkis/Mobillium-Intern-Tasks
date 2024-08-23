package com.example.moviesapptask4a.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.moviesapptask4a.FavoriteMovieDao
import com.example.moviesapptask4a.FavoriteMovieRepository
import com.example.moviesapptask4a.FavoriteRoomDatabase
import com.example.moviesapptask4a.model.FavoriteMovie
import kotlinx.coroutines.launch

class FavoriteMovieViewModel(application: Application) : AndroidViewModel(application) {

    private val favoriteMovieDao: FavoriteMovieDao =
        FavoriteRoomDatabase.getDatabase(application).favoriteMovieDao()
    private val repository = FavoriteMovieRepository(favoriteMovieDao)
    val allFavoriteMovies: LiveData<List<FavoriteMovie>> = repository.getAllFavoriteMovies()

    fun toggleFavorite(movie: FavoriteMovie) {
        viewModelScope.launch {
            if (isFavorite(movie)) {
                repository.insertMovie(movie)
            } else {
                repository.deleteMovie(movie.id)
            }
        }
    }

    fun isFavorite(movie: FavoriteMovie): Boolean {
        return allFavoriteMovies.value?.any { it.id == movie.id } ?: false
    }
}