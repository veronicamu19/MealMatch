package com.example.mealmatch

import java.io.Serializable

data class Person(val name:String,
                  val needsSwipe:Boolean,
                  val emailOrPhone:String,
                  var location:Locations? = null,
                  var time:Int? = null,
                  var id: String = ""): Serializable{
    constructor(): this("",false,"")
}