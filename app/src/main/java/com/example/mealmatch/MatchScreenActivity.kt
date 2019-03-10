package com.example.mealmatch

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.mealmatch.databinding.ActivityMatchscreenBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.database.*
import kotlinx.coroutines.*

class MatchScreenActivity : AppCompatActivity() {

    lateinit var binding: ActivityMatchscreenBinding
    var people = ArrayList<Person>()
    val databaseReference = FirebaseDatabase.getInstance().reference

    private val viewModel: MatchScreenViewModel by lazy {
        ViewModelProviders.of(this,
            MatchScreenViewModelFactory(intent.extras!!.get("PERSON") as Person))
            .get(MatchScreenViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_matchscreen)

        FirebaseApp.initializeApp(this)
        viewModel.uploadPerson()

        val listener: ValueEventListener = object: ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                people = dataSnapshot.children.map{ it.getValue<Person>(Person::class.java) } as ArrayList<Person>
                val sortedMatches = viewModel.sortMatches(people)
                setAdapter(sortedMatches)
            }
            override fun onCancelled(databaseError: DatabaseError) {
            }
        }
        databaseReference.child("people").addListenerForSingleValueEvent(listener)
    }

    fun showMore(view: View){
        val listener: ValueEventListener = object: ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                people = dataSnapshot.children.map{ it.getValue<Person>(Person::class.java) } as ArrayList<Person>
                val sortedMatches = viewModel.sortMatches(people,true)
                setAdapter(sortedMatches)
            }
            override fun onCancelled(databaseError: DatabaseError) {
            }
        }
        databaseReference.child("people").addListenerForSingleValueEvent(listener)
    }

    private fun setAdapter(matches: ArrayList<Person>?){
        if(matches==null){
            val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val popupView: View = inflater.inflate(R.layout.issanomeal, null)

            val width: Int = LinearLayout.LayoutParams.MATCH_PARENT
            val height: Int = LinearLayout.LayoutParams.MATCH_PARENT
            val focusable: Boolean = true; // lets taps outside the popup also dismiss it
            val popupWindow: PopupWindow = PopupWindow(popupView, width, height, focusable);

            // show the popup window
            popupWindow.showAtLocation(binding.rv, Gravity.CENTER, 0, 0);

            val okbtn: Button = popupView.findViewById(R.id.ok)
            okbtn.setOnClickListener {
                popupWindow.dismiss()
                restart(okbtn)
            }
        }
        else {
            val mAdapter: MyAdapter = MyAdapter(matches, this)
            binding.rv.adapter = mAdapter
            mAdapter.onItemClick = { name, contact ->
                showPopUp(name, contact)
            }
        }
    }

    private fun showPopUp(name:String, contact:String) {
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView: View = inflater.inflate(R.layout.itsameal, null)


        val width: Int = LinearLayout.LayoutParams.MATCH_PARENT
        val height: Int = LinearLayout.LayoutParams.MATCH_PARENT
        val focusable: Boolean = true; // lets taps outside the popup also dismiss it
        val popupWindow: PopupWindow = PopupWindow(popupView, width, height, focusable);

        // show the popup window
        popupWindow.showAtLocation(binding.rv, Gravity.CENTER, 0, 0);

        val okbtn: Button = popupView.findViewById(R.id.ok)
        val nametv: TextView = popupView.findViewById(R.id.name_tv)
        val contacttv: TextView = popupView.findViewById(R.id.contact_tv)

        nametv.text = "You can contact " + name + " at:"
        contacttv.text = contact
        okbtn.setOnClickListener {
            popupWindow.dismiss()
        }

    }

    fun restart(view:View){
        startActivity(Intent(this@MatchScreenActivity, MainActivity::class.java))
    }
}
