package com.example.assignment14.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assignment14.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMainLiveData.setOnClickListener {
            gotoActivity(LiveDataActivity::class.java)
        }

        binding.btnMainRoom.setOnClickListener {  }
        binding.btnMainWorkManager.setOnClickListener {  }
        binding.btnMainPaging.setOnClickListener {  }
        binding.btnMainNavigation.setOnClickListener {  }

    }

    private fun gotoActivity(Activity: Class<*>) {
        var intent = Intent(this,Activity)
        startActivity(intent)
    }
}