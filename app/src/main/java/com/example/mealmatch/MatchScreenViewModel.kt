package com.example.mealmatch

import android.arch.lifecycle.ViewModel

class MatchScreenViewModel: ViewModel() {
    fun findMatches(person: Person): ArrayList<Person>{
        //TODO: use algorithm to find matches
        return arrayListOf(Person("Drew",false,"email",Locations.BDH,1200),
            Person("Veronica",false,"phone",Locations.WOODYS,1500))
    }
}