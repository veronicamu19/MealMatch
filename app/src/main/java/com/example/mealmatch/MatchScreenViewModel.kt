package com.example.mealmatch

import android.arch.lifecycle.ViewModel
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MatchScreenViewModel(val person:Person): ViewModel() {

    fun uploadPerson(){
        val databaseReference = FirebaseDatabase.getInstance().reference

        val key = databaseReference.child("people").push().key
        key?.let {
            person.id = key
            databaseReference.child("people").child(key).setValue(person)
        }

    }

    fun findMatches(): ArrayList<Person> {

        return arrayListOf(Person("Drew",false,"email",Locations.BDH,1200),
            Person("Veronica",false,"phone",Locations.WOODYS,1500))
    }
}

        /*
        val personID=(ref.push().key).toString()
        person.id=personID
        ref.child("people").child(personID).setValue(person)


        val firebaseData = FirebaseDatabase.getInstance()
        val key = firebaseData.child("people").push().key
        availableSalads.forEach {
            val key = firebaseData.child("salads").push().key
            it.uuid = key
            firebaseData.child("salads").child(key).setValue(it)
        }*/