package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

enum class Operator{
    ADD, SUBTRACT, MULTIPLY, DIVIDE
}

class MainActivity : AppCompatActivity() {
    private var operand1 = 0f
    private var operator: Operator = Operator.ADD
    private var operand2 = 0f
    private var result = 0f

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculusArea = findViewById<TextView>(R.id.calculusArea)

        val button0 = findViewById<Button>(R.id.button0)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)

        val buttonClear = findViewById<Button>(R.id.buttonClear)
        val buttonBack = findViewById<Button>(R.id.buttonBack)

        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        val buttonSubtract = findViewById<Button>(R.id.buttonSubtract)
        val buttonMultiply = findViewById<Button>(R.id.buttonMultiply)
        val buttonDivide = findViewById<Button>(R.id.buttonDivide)
        val buttonEqual = findViewById<Button>(R.id.buttonEqual)

        button0.setOnClickListener {
            insertDigit("0", calculusArea)
        }
        button1.setOnClickListener {
            insertDigit("1", calculusArea)
        }
        button2.setOnClickListener {
            insertDigit("2", calculusArea)
        }
        button3.setOnClickListener {
            insertDigit("3", calculusArea)
        }
        button4.setOnClickListener {
            insertDigit("4", calculusArea)
        }
        button5.setOnClickListener {
            insertDigit("5", calculusArea)
        }
        button6.setOnClickListener {
            insertDigit("6", calculusArea)
        }
        button7.setOnClickListener {
            insertDigit("7", calculusArea)
        }
        button8.setOnClickListener {
            insertDigit("8", calculusArea)
        }
        button9.setOnClickListener {
            insertDigit("9", calculusArea)
        }

        buttonAdd.setOnClickListener{
            setOperator(Operator.ADD, calculusArea)
        }
        buttonSubtract.setOnClickListener {
            setOperator(Operator.SUBTRACT, calculusArea)
        }
        buttonMultiply.setOnClickListener {
            setOperator(Operator.MULTIPLY, calculusArea)
        }
        buttonDivide.setOnClickListener{
            setOperator(Operator.DIVIDE, calculusArea)
        }
        buttonEqual.setOnClickListener {
            operand2 = if (calculusArea.text.length > 0) calculusArea.text.toString().toFloat() else 0f
            result = calculate(operand1, operand2, operator)
            calculusArea.text = result.toString()

            operand1 = 0f
            operand2 = 0f
            operator = Operator.ADD
        }

        buttonClear.setOnClickListener {
            clear(calculusArea)
        }
        buttonBack.setOnClickListener {
            back(calculusArea)
        }
    }

    private fun insertDigit(digit: String, calculusArea: TextView){
        (calculusArea.text.toString() + digit).also { calculusArea.text = it }
    }

    private fun setOperator(operator: Operator, calculusArea: TextView){
        this.operator = operator
        operand1 = calculusArea.text.toString().toFloat()
        operand2 = 0f
        calculusArea.text = ""
    }

    private fun calculate(op1: Float, op2: Float, op: Operator): Float{
        val result: Float = when(op){
            Operator.ADD -> op1 + op2
            Operator.SUBTRACT -> op1 - op2
            Operator.MULTIPLY -> op1 * op2
            Operator.DIVIDE -> op1 / op2
        }

        return result
    }

    private fun clear(calculusArea: TextView){
        operand1 = 0f
        operand2 = 0f
        operator = Operator.ADD
        result = 0f
        calculusArea.text = ""
    }

    private fun back(calculusArea: TextView){
        calculusArea.text = calculusArea.text.toString().dropLast(1)
    }
}