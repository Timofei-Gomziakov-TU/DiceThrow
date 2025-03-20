package edu.temple.dicethrow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class DieViewModel : ViewModel() {
    private val currentRoll : MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(0)
    }

    public fun getCurrentRoll() : LiveData<Int> {
        return currentRoll
    }

    public fun setCurrentRoll(value : Int) {
        currentRoll.value = value
    }
    public fun rollDie(){
        setCurrentRoll((Random.nextInt(20) + 1))
    }
}