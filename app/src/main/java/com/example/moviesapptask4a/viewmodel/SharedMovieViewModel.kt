package com.example.moviesapptask4a.viewmodel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesapptask4a.model.MoviesItem

class SharedMovieViewModel : ViewModel() {

    val favoriteMovies : MutableLiveData<MutableSet<MoviesItem>> = MutableLiveData()

    fun toggleFavorite(movie: MoviesItem) {
        val currentFavorites = favoriteMovies.value ?: mutableSetOf()
        if (currentFavorites.contains(movie)) {
            currentFavorites.remove(movie)
        } else {
            currentFavorites.add(movie)
        }
        favoriteMovies.value = currentFavorites
    }

    fun isFavorite(movie: MoviesItem): Boolean {
        return favoriteMovies.value?.contains(movie) ?: false
    }
}
