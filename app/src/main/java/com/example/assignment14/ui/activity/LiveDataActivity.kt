package com.example.assignment14.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.assignment14.R
import com.example.assignment14.databinding.ActivityLiveDataBinding
import com.example.assignment14.ui.fragment.PageNumberFragment

class LiveDataActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLiveDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLiveDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}