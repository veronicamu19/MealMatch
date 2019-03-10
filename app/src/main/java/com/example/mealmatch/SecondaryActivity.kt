package com.example.mealmatch

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.View
import com.example.mealmatch.databinding.ActivityMainBinding
import com.example.mealmatch.databinding.ActivitySecondaryBinding

import kotlinx.android.synthetic.main.activity_secondary.*
import android.widget.ArrayAdapter



class SecondaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondaryBinding
    private val viewModel: SecondaryViewModel by lazy {
        ViewModelProviders.of(this,
            SecondaryViewModelFactory(intent.extras!!.get("PERSON") as Person))
            .get(SecondaryViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_secondary)
        setLocationAdapter()
    }

    private fun setLocationAdapter(){
        val locationStrings: ArrayList<String> = enumValues<Locations>().map{it.getTitle()} as ArrayList<String>
        val locationAdapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this, android.R.layout.simple_list_item_1,locationStrings)
        binding.diningLocation.setAdapter(locationAdapter)
    }

    fun showMatches(view: View){
        val location: Locations? = enumValues<Locations>().find{it.getTitle().equals(binding.diningLocation.text.toString())}
        if(location!=null){
            viewModel.addLocation(location)
            viewModel.addTime(binding.time.hour,binding.time.minute)
            val intent = Intent(this@SecondaryActivity, MatchScreenActivity::class.java)
            intent.putExtra("PERSON",viewModel.person)
            startActivity(intent)
        }
    }
}
