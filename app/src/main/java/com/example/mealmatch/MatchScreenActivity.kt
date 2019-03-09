package com.example.mealmatch

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
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
        binding.rv.adapter = MyAdapter(matches, this)
    }
}
