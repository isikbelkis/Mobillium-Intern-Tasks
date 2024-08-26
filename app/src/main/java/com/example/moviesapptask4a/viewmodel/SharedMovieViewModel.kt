package com.example.moviesapptask4a.viewmodel

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviesapptask4a.model.MoviesItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SharedMovieViewModel(application: Application) : AndroidViewModel(application) {

    private val sharedPreferences: SharedPreferences =
        application.getSharedPreferences("favorites_prefs", Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = sharedPreferences.edit()
    private val gson = Gson()

    private val favoriteMovies = MutableLiveData<MutableList<MoviesItem>>()
    val favoriteMoviesLiveData: LiveData<MutableList<MoviesItem>> = favoriteMovies

    init {
        favoriteMovies.value = loadFavorites()
    }

    private fun loadFavorites(): MutableList<MoviesItem> {
        val json = sharedPreferences.getString("favorite_movies", null)
        return if (json != null) {
            val type = object : TypeToken<MutableList<MoviesItem>>() {}.type
            gson.fromJson(json, type)
        } else {
            mutableListOf()
        }
    }

    private fun saveFavorites(favorites: MutableList<MoviesItem>) {
        val json = gson.toJson(favorites)
        editor.putString("favorite_movies", json)
        editor.apply()
    }

    fun toggleFavorite(movie: MoviesItem) {
        val currentFavorites = favoriteMovies.value ?: mutableListOf()

        if (currentFavorites.contains(movie)) {
            currentFavorites.remove(movie)

        } else {
            currentFavorites.add(movie)
            movie.isFavorite = true
        }
        favoriteMovies.value = currentFavorites
        saveFavorites(currentFavorites)
    }

    fun isFavorite(movie: MoviesItem): Boolean {
        return favoriteMovies.value?.contains(movie) ?: false
    }
}
