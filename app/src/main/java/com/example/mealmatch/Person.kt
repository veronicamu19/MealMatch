package com.example.mealmatch

import java.io.Serializable

data class Person(val name:String,
                  val needsSwipe:Boolean,
                  val emailOrPhone:String,
                  val location:Locations? = null,
                  val time:Int? = null): Serializable{
}