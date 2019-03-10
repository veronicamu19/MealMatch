package com.example.mealmatch

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
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
import kotlinx.coroutines.*

class MatchScreenActivity : AppCompatActivity() {

    lateinit var binding: ActivityMatchscreenBinding
    private val viewModel: MatchScreenViewModel by lazy {
        ViewModelProviders.of(this).get(MatchScreenViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_matchscreen)

        GlobalScope.launch(Dispatchers.IO) {
            val matches = viewModel.findMatches(intent.extras!!.get("PERSON") as Person)
            setAdapter(matches)  // In main thread
        }
    }

    private fun setAdapter(matches: ArrayList<Person>){
        val mAdapter: MyAdapter = MyAdapter(matches,this)
        binding.rv.adapter = mAdapter
        mAdapter.onItemClick = { name, contact ->
            showPopUp(name, contact)
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
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(binding.rv, Gravity.CENTER, 0, 0);

        val okbtn: Button = popupView.findViewById(R.id.ok)
        val nametv: TextView = popupView.findViewById(R.id.name_tv)
        val contacttv: TextView = popupView.findViewById(R.id.contact_tv)

        nametv.text = "You can contact " + name + " at:"
        contacttv.text = contact
        okbtn.setOnClickListener {
            popupWindow.dismiss()
        }

        /* dismiss the popup window when touched
        popupView.setOnTouchListener(View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });*/

    }
}
