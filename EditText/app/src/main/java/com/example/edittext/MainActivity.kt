package com.example.edittext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
//import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textInput = findViewById<EditText>(R.id.textInput)
        val image = findViewById<ImageView>(R.id.imageView)

        textInput.addTextChangedListener {
            Log.d("Text Changed", textInput.text.toString())
        }

        //image.setImageDrawable(ContextCompat.getDrawable(this, androidx.appcompat.R.drawable.abc_btn_check_material))
        //Picasso.get().load("https://c4.wallpaperflare.com/wallpaper/500/442/354/outrun-vaporwave-hd-wallpaper-preview.jpg").into(image)
        Picasso.get().load("https://c.tenor.com/YdROcIDBlWAAAAAd/gif-wallpaper.gif").into(image)
    }
}