package com.example.mealmatch

import android.arch.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    lateinit var person:Person

    fun createPerson(name:String, needsSwipe:Boolean, emailOrPhone:String){
        person = Person(name,needsSwipe,emailOrPhone)
    }
}