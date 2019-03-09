package com.example.mealmatch

data class Person(val name:String,
                  val needsSwipe:Boolean,
                  val emailOrPhone:String,
                  val location:Locations,
                  val time:Int) {
}