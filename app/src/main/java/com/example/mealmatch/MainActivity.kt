package com.example.mealmatch

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.view.View
import com.example.mealmatch.databinding.ActivityMainBinding
import com.example.mealmatch.R.layout.activity_main



class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, activity_main)
    }

    fun nextActivity(view: View){
        when(view){
            binding.swipeMeIn ->{
                viewModel.createPerson(binding.name.text.toString(),true,binding.phoneemail.text.toString())
                launchNextActivity()
            }
            binding.swipeSomeoneIn ->{
                viewModel.createPerson(binding.name.text.toString(),false,binding.phoneemail.text.toString())
                launchNextActivity()
            }
        }
    }

    private fun launchNextActivity(){
        val intent = Intent(this@MainActivity, SecondaryActivity::class.java)
        intent.putExtra("PERSON",viewModel.person)
        startActivity(intent)
    }
}
