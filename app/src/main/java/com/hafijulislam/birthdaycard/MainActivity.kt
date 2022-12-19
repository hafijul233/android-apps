package com.hafijulislam.birthdaycard

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Dice(private val sides: Int = 6) {

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

            val dice: Dice = Dice()

            val randomNumber: Int = dice.roll()

            if (randomNumber == 3) {
                val toast = Toast.makeText(
                    this,
                    "It's your Lucky number \uD83E\uDD73",
                    Toast.LENGTH_SHORT
                )
                toast.show()
            }

            this.updateImage(randomNumber)
        }
    }

    private fun updateImage(number: Int) {

        val diceImage: ImageView = findViewById(R.id.imageView3)

        diceImage.contentDescription = number.toString()

        (when (number) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        })
    }
}