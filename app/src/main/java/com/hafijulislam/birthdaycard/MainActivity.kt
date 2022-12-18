package com.hafijulislam.birthdaycard

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Dice(val sides: Int = 6) {

    fun roll(): Int {
        return (1..this.sides).random()

    }
}

class MainActivity : AppCompatActivity() {
    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener {
            val dice: Dice = Dice(6)
            val randomNumber: Int = dice.roll()
            val luckyNumber = 3

            val randomTextView: TextView = findViewById(R.id.textView)

            randomTextView.text = randomNumber.toString()

            val message: String = if (randomNumber == luckyNumber) {
                "It's your Lucky number \uD83E\uDD73"
            } else {
                "\uD83C\uDFB2 Dice rolled ${randomNumber}"
            }

            val toast = Toast.makeText(this, message, Toast.LENGTH_LONG)
            toast.show()
        }
    }
}