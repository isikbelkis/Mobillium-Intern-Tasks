package com.example.moviesapptask4a.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapptask4a.R
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
                    MovieClient.getClient().getMoviesPopularList(token = Constans.BEARER_TOKEN)
                Log.d("DetailViewModel", "API Response: ${popularResponse.body()}")
                if (popularResponse.isSuccessful) {

                    popularMoviesList.postValue(popularResponse.body()?.moviesItem)
                } else {
                    if (popularResponse.message().isNullOrEmpty()) {
                        errorMessage.value = R.string.errorMessage.toString()
                    } else {
                        errorMessage.value = popularResponse.message()
                    }
                }

                val topRatedResponse =
                    MovieClient.getClient().getMoviesTopRatedList(token = Constans.BEARER_TOKEN)
                if (topRatedResponse.isSuccessful) {
                    topRatedMoviesList.postValue(topRatedResponse.body()?.moviesItem)
                } else {
                    if (topRatedResponse.message().isNullOrEmpty()) {
                        errorMessage.value = R.string.errorMessage.toString()
                    } else {
                        errorMessage.value = topRatedResponse.message()
                    }
                }

                val upcomingResponse =
                    MovieClient.getClient().getMoviesUpcomingList(token = Constans.BEARER_TOKEN)
                if (upcomingResponse.isSuccessful) {
                    upcomingMoviesList.postValue(upcomingResponse.body()?.moviesItem)
                } else {
                    if (upcomingResponse.message().isNullOrEmpty()) {
                        errorMessage.value = R.string.errorMessage.toString()
                    } else {
                        errorMessage.value = upcomingResponse.message()
                    }
                }
            } catch (e: Exception) {
                errorMessage.value = e.message
            } finally {
                isLoading.value = false
            }
        }
    }
}
