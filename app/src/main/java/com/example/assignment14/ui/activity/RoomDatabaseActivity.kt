package com.example.assignment14.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assignment14.databinding.ActivityRoomDatabaseBinding

class RoomDatabaseActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRoomDatabaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomDatabaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}