package com.example.mealmatch

import android.arch.lifecycle.ViewModel
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*
import kotlin.math.abs

class MatchScreenViewModel(val person:Person): ViewModel() {
    val databaseReference = FirebaseDatabase.getInstance().reference

    fun uploadPerson(){
        val key = databaseReference.child("people").push().key
        key?.let {
            person.id = key
            databaseReference.child("people").child(key).setValue(person)
        }
    }

    fun sortMatches(people:ArrayList<Person>): ArrayList<Person>? {
        var sortedMatches: List<Person>
        when(person.needsSwipe){
            true -> {
                sortedMatches = people.filter { !it.needsSwipe }
            }
            false ->{
                sortedMatches = people.filter{it.needsSwipe}
            }
        }
        sortedMatches=sortedMatches.filter {it.location==person.location}
        sortedMatches=sortedMatches.filter { abs(it.time!!-person.time!!)<30 }
        if(sortedMatches.isEmpty()){
            return null
        }
        return sortedMatches as ArrayList<Person>?
    }
}