package com.example.app1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.app1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("Unusable Variable")
        val binding=DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
    }
}