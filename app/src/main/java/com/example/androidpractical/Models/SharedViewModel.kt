package com.example.androidpractical.Models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val mutableLiveData: MutableLiveData<CharSequence> = MutableLiveData()

    fun setData(input: CharSequence) {
        mutableLiveData.value = input
    }

    fun getData(): MutableLiveData<CharSequence> = mutableLiveData
}