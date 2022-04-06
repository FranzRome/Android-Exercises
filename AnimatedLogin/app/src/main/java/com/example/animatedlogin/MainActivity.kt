package com.example.animatedlogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private val email = "abc"
    private val password = "abc"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.enterButton)
        val mailInput = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val passwordInput = findViewById<EditText>(R.id.editTextTextPassword)
        val contextView = findViewById<ConstraintLayout>(R.id.root)




        button.setOnClickListener {
            if(mailInput.text.toString() == email && passwordInput.text.toString() == password){
                val intent = Intent(this, Profile::class.java)
                startActivity(intent)
                overridePendingTransition(R.anim.transition, R.anim.nothing)
            } else {
                Snackbar.make(contextView, R.string.login_error, Snackbar.LENGTH_SHORT)
                    .show()
            }
        }
    }
}