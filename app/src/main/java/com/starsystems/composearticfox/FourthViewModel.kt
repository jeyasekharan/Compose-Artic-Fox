package com.starsystems.composearticfox

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FourthViewModel: ViewModel() {

    private val _name = MutableLiveData("")

    val name: LiveData<String> = _name

    fun onNameChanged(newString: String, newString2: String) {
        _name.value = newString
    }
}