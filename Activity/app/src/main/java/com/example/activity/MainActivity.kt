package com.example.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("Activity status", "onCreate()")
    }

    override fun onStart() {
        super.onStart()

        Log.d("Activity status", "onStart()")
    }

    override fun onResume() {
        super.onResume()

        Log.d("Activity status", "onResume()")
    }
}