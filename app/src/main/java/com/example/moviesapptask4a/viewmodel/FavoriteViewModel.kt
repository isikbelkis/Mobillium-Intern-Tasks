package com.example.moviesapptask4a.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesapptask4a.model.MoviesItem

class FavoriteViewModel : ViewModel() {
    val favoriteMovies: MutableLiveData<Set<MoviesItem>> = MutableLiveData()

    fun toggleFavorite(movie: MoviesItem) {
        val currentFavorites = favoriteMovies.value ?: emptySet()
        val updatedFavorites = if (currentFavorites.contains(movie)) {
            currentFavorites - movie
        } else {
            currentFavorites + movie
        }
        favoriteMovies.value = updatedFavorites
    }

    fun getFavoriteMovies(): Set<MoviesItem> {
        return favoriteMovies.value ?: emptySet()
    }
}