package com.example.interntasks3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val hiddenNumber = MutableLiveData<Int>()
    val hiddenNumberLiveData: LiveData<Int>
        get() = hiddenNumber

    fun hiddenNumbers(number: Int) {
        hiddenNumber.value = number
    }
}