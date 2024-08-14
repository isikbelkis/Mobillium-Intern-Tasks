package com.example.moviesapptask4a.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapptask4a.R
import com.example.moviesapptask4a.model.Cast
import com.example.moviesapptask4a.model.MovieDetailResponse
import com.example.moviesapptask4a.network.MovieClient
import com.example.moviesapptask4a.util.Constans
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
                val detailResponse = MovieClient.getClient()
                    .getMovieDetail(movieId = movieId.toString(), token = Constans.BEARER_TOKEN)
                Log.d("DetailViewModel", "API Response: ${detailResponse.body()}")

                if (detailResponse.isSuccessful) {
                    movieResponse.postValue(detailResponse.body())
                } else {
                    if (detailResponse.message().isNullOrEmpty()) {
                        errorMessage.value = R.string.errorMessage.toString()
                    } else {
                        errorMessage.value = detailResponse.message()
                    }
                }

                val actorsResponse = MovieClient.getClient()
                    .getMovieActors(movieId = movieId.toString(), token = Constans.BEARER_TOKEN)

                if (actorsResponse.isSuccessful) {
                    actorsList.postValue(actorsResponse.body()?.cast)
                } else {
                    if (actorsResponse.message().isNullOrEmpty()) {
                        errorMessage.value = R.string.errorMessage.toString()
                    } else {
                        errorMessage.value = actorsResponse.message()
                    }
                }
            } catch (e: Exception) {
                isLoading.value = false
            } finally {
                isLoading.value = false
            }
        }
    }
}