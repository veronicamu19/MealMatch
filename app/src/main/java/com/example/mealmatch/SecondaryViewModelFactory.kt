package com.example.mealmatch

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class SecondaryViewModelFactory(val person: Person): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SecondaryViewModel(person) as T
    }
}