package com.example.moviesapptask4a.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.moviesapptask4a.FavoriteMovieRepository
import com.example.moviesapptask4a.FavoriteRoomDatabase
import com.example.moviesapptask4a.model.FavoriteMovie
import com.example.moviesapptask4a.model.MoviesItem
import com.example.moviesapptask4a.network.MovieClient
import kotlinx.coroutines.launch

class ListViewModel(application: Application) : AndroidViewModel(application) {
    val _favoriteMovies : MutableLiveData<List<MoviesItem>> = MutableLiveData()
    val popularMoviesList: MutableLiveData<List<MoviesItem>> = MutableLiveData()
    val topRatedMoviesList: MutableLiveData<List<MoviesItem>> = MutableLiveData()
    val upcomingMoviesList: MutableLiveData<List<MoviesItem>> = MutableLiveData()
    val isLoading = MutableLiveData(false)
    val errorMessage: MutableLiveData<String?> = MutableLiveData()

    private val repository: FavoriteMovieRepository
    val favoriteMovies: LiveData<List<FavoriteMovie>>

    fun getMovieList() {
        isLoading.value = true
        viewModelScope.launch {
            try {
                val popularResponse =
                    MovieClient.movieService.getMoviesPopularList()
                if (popularResponse.isSuccessful) {
                    popularMoviesList.postValue(popularResponse.body()?.moviesItem)
                }
                val topRatedResponse =
                    MovieClient.movieService.getMoviesTopRatedList()
                if (topRatedResponse.isSuccessful) {
                    topRatedMoviesList.postValue(topRatedResponse.body()?.moviesItem)
                }
                val upcomingResponse =
                    MovieClient.movieService.getMoviesUpcomingList()
                if (upcomingResponse.isSuccessful) {
                    upcomingMoviesList.postValue(upcomingResponse.body()?.moviesItem)
                }
            } catch (e: Exception) {
                errorMessage.value = e.message
            } finally {
                isLoading.value = false
            }
        }
    }

    init {
        val favoriteDao = FavoriteRoomDatabase.getDatabase(application).favoriteMovieDao()
        repository = FavoriteMovieRepository(favoriteDao)
        favoriteMovies = repository.getAllFavoriteMovies()
    }

    fun toggleFavorite(movie: MoviesItem) {
        viewModelScope.launch {
            val isFavorite = repository.isMovieFavorite(movie.id!!).value ?: false
            if (isFavorite) {
                repository.deleteMovie(movie.id)
            } else {
                repository.insertMovie(FavoriteMovie(movie.id, movie.title!!, movie.posterPath!!))
            }
            _favoriteMovies.postValue(_favoriteMovies.value?.toMutableList()?.apply {
                if (isFavorite) remove(movie) else add(movie)
            })
        }
    }

    fun isFavorite(movieId: Int): LiveData<Boolean> {
        return repository.isMovieFavorite(movieId)
    }
}
