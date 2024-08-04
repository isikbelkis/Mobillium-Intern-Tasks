package com.example.interntasks3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GuessGameViewModel : ViewModel() {

    private val randomNumber = MutableLiveData<Int>()
    val randomNumberLiveData: LiveData<Int>
        get() = randomNumber

    private val result = MutableLiveData<String>()
    val resultLiveData: LiveData<String>
        get() = result

    private val randomChar = MediatorLiveData<Char>()
    val randomCharLiveData: LiveData<Char>
        get() = randomChar

    var guessedNumber: Int? = null

    init {
        startGame()
    }

    fun startGame() {
        randomNumber.value = (0..9).random()
        randomChar.value = ('A'..'Z').random()
    }

    fun updateGuessedNumber(number: String) {
        guessedNumber = number.toInt()
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
        guessedNumber = null
        randomChar.value = randomNumber.value.toString().first()
        startGame()
    }
}