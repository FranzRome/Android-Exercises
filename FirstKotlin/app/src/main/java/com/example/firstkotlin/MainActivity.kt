package com.example.firstkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private val constant = 11
    private var hello = "abc"
    private var hello1 : String? = null  // With ? modifier it can be null
    private lateinit var text : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var concat = "abc" + "bcd"
        var concat1 = "$concat $hello"
        
        Log.d("my_key", constant.toString())
        Log.d("my_key", hello.length.toString())
        Log.d("my_key", hello1?.length.toString())
        
        var items = listOf<String>("apple", "banana", "orange")

        // Were statement
        var number = 42

        // Old if/else statement
        if(number == 1) {
            Log.d("my_key", "Valore 1")
        } else if(number == 2) {
            Log.d("my_key", "Valore 2")
        } else if(number == 3) {
            Log.d("my_key", "Valore 3")
        } else {
            Log.d("my_key", "No valore")
        }

        // New When statement
        when(number) {
            1 -> Log.d("my_key", "Valore 1")
            2 -> Log.d("my_key", "Valore 2")
            3 -> Log.d("my_key", "Valore 3")
            else -> Log.d("my_key", "No valore")
        }

        // Try/catch
        try{
            number /= 0
        } catch (e: Exception){
            Log.e("try/catch", "Errore: ", e)
        }

        // Point to view elements
        var number1 = findViewById<EditText>(R.id.number1)
        var number2 = findViewById<EditText>(R.id.number2)
        var calculateButton = findViewById<Button>(R.id.calculate)
        var resultText = findViewById<TextView>(R.id.result)

        calculateButton.setOnClickListener { Log.d("", "Click!") }

        resultText.text = sum(number1.text.toString().toInt(),
                              number2.text.toString().toInt()).toString()
    }

    // Function template
    private fun functionName(param: String?): Int? {
        return param?.length
    }

    private fun sum(a: Int, b: Int): Int? {
        return a + b
    }
}