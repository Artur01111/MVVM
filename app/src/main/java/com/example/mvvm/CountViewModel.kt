package com.example.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel: ViewModel() {

    private val model = CounterModel()
    val liveData = MutableLiveData<Int>()

    fun increment(){
        model.increment()
        liveData.value = model.getCount()
    }
    fun decrement(){
        model.decrement()
        liveData.value = model.getCount()
    }
}