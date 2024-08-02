package com.example.interntasks3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GuessGameViewModel : ViewModel() {

    private val randomNumber = MutableLiveData<Int>().apply {
        value = (0..9).random()
    }
    val randomNumberLiveData: LiveData<Int>
        get() = randomNumber

    private val result = MutableLiveData<String>()
    val resultLiveData: LiveData<String>
        get() = result

    private val randomChar = MediatorLiveData<String>()
    val randomCharLiveData: LiveData<String>
        get() = randomChar

    var guessedNumber: Int? = null

    init {
        randomChar.addSource(randomNumber) { number ->
            randomChar.value = (number + 'A'.code).toChar().toString()
        }
    }

    fun updateGuessedNumber(number: Int) {
        guessedNumber = number
    }

    fun checkGuess() {
        val actualNumber = randomNumber.value
        if (guessedNumber == actualNumber) {
            result.value = "Kazandınız"
        } else {
            result.value = "Tekrar deneyiniz"
        }
    }

    fun resetGame() {
        randomNumber.value = (0..9).random()
        guessedNumber = null
        result.value = ""
    }
}