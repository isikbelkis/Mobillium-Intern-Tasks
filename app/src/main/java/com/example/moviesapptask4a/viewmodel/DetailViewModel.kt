package com.example.moviesapptask4a.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapptask4a.model.Cast
import com.example.moviesapptask4a.model.MovieDetailResponse
import com.example.moviesapptask4a.network.MovieClient
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {

    val movieResponse: MutableLiveData<MovieDetailResponse> = MutableLiveData()
    val isLoading = MutableLiveData(false)
    val errorMessage: MutableLiveData<String?> = MutableLiveData()
    val actorsList: MutableLiveData<List<Cast?>?> = MutableLiveData()

    fun getMovieDetail(movieId: Int) {
        isLoading.value = true

        viewModelScope.launch {
            try {
                val detailResponse = MovieClient.movieService
                    .getMovieDetail(movieId = movieId.toString())

                if (detailResponse.isSuccessful) {
                    movieResponse.postValue(detailResponse.body())
                }
                val actorsResponse = MovieClient.movieService
                    .getMovieActors(movieId = movieId.toString())

                if (actorsResponse.isSuccessful) {
                    actorsList.postValue(actorsResponse.body()?.cast)
                }
            } catch (e: Exception) {
                isLoading.value = false
            } finally {
                isLoading.value = false
            }
        }
    }
}