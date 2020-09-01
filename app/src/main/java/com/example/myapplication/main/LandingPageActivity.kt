package com.example.myapplication.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityLandingPageBinding
import com.example.myapplication.main.home.HomeActivity
import com.example.myapplication.main.style.StyleGuideActivity

class LandingPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityLandingPageBinding>(
            this,
            R.layout.activity_landing_page
        )
        binding.landingPageGuidelineScreenButton.setOnClickListener {
            Intent(this, StyleGuideActivity::class.java).also { startActivity(it) }
        }
        binding.landingPageHomeScreenButton.setOnClickListener {
            Intent(this, HomeActivity::class.java).also { startActivity(it) }
        }
    }
}