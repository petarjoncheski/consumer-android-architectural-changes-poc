package com.example.myapplication.main.style

import android.content.Intent
import android.os.Bundle
import androidx.annotation.StyleRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityStyleguideBinding


class StyleGuideActivity : AppCompatActivity() {
    companion object {
        var theme = R.style.AppTheme
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(StyleGuideActivity.theme)
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityStyleguideBinding>(
            this,
            R.layout.activity_styleguide
        )
        binding.applyDefaultTheme.setOnClickListener {
            applyTheme(R.style.AppTheme)
        }
        binding.applyTheme2.setOnClickListener {
            applyTheme(R.style.AppTheme_Dark)
        }
    }

    private fun applyTheme(@StyleRes nextTheme: Int) {
        StyleGuideActivity.theme = nextTheme
        finish()
        startActivity(Intent(this, StyleGuideActivity::class.java))
    }
}