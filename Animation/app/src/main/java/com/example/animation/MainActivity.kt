package com.example.animation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animationView = findViewById<View>(R.id.animationView)
        animationView.alpha = 0f
        animationView.animate()
            .alpha(1f)
            .setDuration(3000)
            .translationXBy(400f).start()

        val animationButton = findViewById<Button>(R.id.animationButton)
        animationButton.setOnClickListener {
            animationView.animate().alpha(0f).setDuration(3000).translationXBy(160f).start()
        }
    }
}