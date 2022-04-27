package com.example.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Main Fragment"
    }
    val text: LiveData<String> = _text
    var length: MutableLiveData<Int> = MutableLiveData<Int>()

    fun updateLength(value: String) {
        length.value = text.value?.length
    }
}