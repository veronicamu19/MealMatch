package com.example.mealmatch

import android.arch.lifecycle.ViewModel

class SecondaryViewModel(val person: Person): ViewModel() {
    fun addLocation(location: Locations){
        person.location = location
    }
    fun addTime(hr: Int, min: Int){
        person.time = hr*100 + min
    }
}