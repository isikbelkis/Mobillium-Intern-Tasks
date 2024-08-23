package com.example.moviesapptask4a.viewmodel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesapptask4a.model.MoviesItem

class SharedMovieViewModel : ViewModel() {

    val favoriteMovies: MutableLiveData<Set<MoviesItem>> = MutableLiveData(emptySet())

    fun toggleFavorite(movie: MoviesItem) {
        val currentFavorites = favoriteMovies.value ?: emptySet()
        val updatedFavorites = if (currentFavorites.contains(movie)) {
            currentFavorites - movie
        } else {
            currentFavorites + movie
        }
        favoriteMovies.value = updatedFavorites
    }

    fun isFavorite(movie: MoviesItem): Boolean {
        return favoriteMovies.value?.contains(movie) ?: false
    }
}
