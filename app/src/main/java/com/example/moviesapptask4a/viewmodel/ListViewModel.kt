package com.example.moviesapptask4a.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.moviesapptask4a.model.MoviesItem
import com.example.moviesapptask4a.network.MovieClient
import kotlinx.coroutines.launch

class ListViewModel(application: Application) : AndroidViewModel(application) {

    val popularMoviesList: MutableLiveData<List<MoviesItem>> = MutableLiveData()
    val topRatedMoviesList: MutableLiveData<List<MoviesItem>> = MutableLiveData()
    val upcomingMoviesList: MutableLiveData<List<MoviesItem>> = MutableLiveData()
    val isLoading = MutableLiveData(false)
    val errorMessage: MutableLiveData<String?> = MutableLiveData()

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
}