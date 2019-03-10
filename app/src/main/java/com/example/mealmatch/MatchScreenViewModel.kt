package com.example.mealmatch

import android.arch.lifecycle.ViewModel
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MatchScreenViewModel: ViewModel() {
    fun findMatches(person: Person): ArrayList<Person>{
        //TODO: use algorithm to find matches

        /*val ref=FirebaseDatabase.getInstance().getReference("people")
        val personID=(ref.push().key).toString()
        person.id=personID
        ref.child("people").child(personID).setValue(person)*/
        return arrayListOf(Person("Drew",false,"email",Locations.BDH,1200),
            Person("Veronica",false,"phone",Locations.WOODYS,1500))
    }
}