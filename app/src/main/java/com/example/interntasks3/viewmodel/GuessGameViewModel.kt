package com.example.interntasks3.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.interntasks3.R

class GuessGameViewModel : ViewModel() {

    private val randomNumber = MutableLiveData<Int>()
    val randomNumberLiveData: LiveData<Int>
        get() = randomNumber

    private val result = MutableLiveData<String>()
    val resultLiveData: LiveData<String>
        get() = result

    private val randomChar = MutableLiveData<Char>()
    val randomCharLiveData: LiveData<Char>
        get() = randomChar

    private val resultMessage=MutableLiveData<Int>()
    val resultMessageLiveData: LiveData<Int>
        get() = resultMessage

    private var guessedNumber: Int? = null

    init {
        startGame()
    }

    private fun startGame() {
        randomNumber.value = (0..9).random()
        randomChar.value = ('A'..'Z').random()
    }

    fun updateGuessedNumber(number: String) {
        guessedNumber = number.toInt()
    }

    fun checkGuess() {
        val actualNumber = randomNumber.value
        if (guessedNumber == actualNumber) {
            resultMessage.postValue((R.string.result_success))
        } else {
            resultMessage.postValue(R.string.result_fail)
        }
    }

    fun resetGame() {
        startGame()
    }
}