package com.example.mealmatch

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class MatchScreenViewModelFactory(val person: Person): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MatchScreenViewModel(person) as T
    }
}