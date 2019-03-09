package com.example.mealmatch

import android.arch.lifecycle.ViewModel

class SecondaryViewModel(val person: Person): ViewModel() {
    fun addLocation(location: Locations){
        person.location = location
    }
    fun addTime(time: Int){
        person.time = time
    }
}