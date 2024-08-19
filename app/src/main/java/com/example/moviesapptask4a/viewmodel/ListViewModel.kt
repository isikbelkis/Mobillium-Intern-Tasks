package com.example.moviesapptask4a.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapptask4a.model.MoviesItem
import com.example.moviesapptask4a.network.MovieClient
import com.example.moviesapptask4a.util.Constans
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

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
                    MovieClient.movieService.getMoviesPopularList(token = Constans.BEARER_TOKEN)
                if (popularResponse.isSuccessful) {
                    popularMoviesList.postValue(popularResponse.body()?.moviesItem)
                }
                val topRatedResponse =
                    MovieClient.movieService.getMoviesTopRatedList(token = Constans.BEARER_TOKEN)
                if (topRatedResponse.isSuccessful) {
                    topRatedMoviesList.postValue(topRatedResponse.body()?.moviesItem)
                }
                val upcomingResponse =
                    MovieClient.movieService.getMoviesUpcomingList(token = Constans.BEARER_TOKEN)
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
