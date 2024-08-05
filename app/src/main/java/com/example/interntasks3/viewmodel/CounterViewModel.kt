package com.example.interntasks3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    private val count = MutableLiveData(0)
    val countLiveData: LiveData<Int> get() = count

    fun incrementCount() {
        count.value = (count.value ?: 0) + 1
    }
}