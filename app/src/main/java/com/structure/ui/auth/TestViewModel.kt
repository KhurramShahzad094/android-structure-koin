package com.structure.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class TestViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    var name = MutableLiveData<String>()

    // GOOD: Encapsulate access to mutable LiveData using backing property
    private val _offers = MutableLiveData<String>()
    val offers: LiveData<String> = _offers
}
