package edu.temple.dicethrow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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
}