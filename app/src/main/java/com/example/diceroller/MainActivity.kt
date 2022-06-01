package com.example.diceroller

// Imports required for program use
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// Main Code
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Get the Button on Main View and have the button roll dice onClick
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        //Roll dice when Application starts
        rollDice()
    }


    private fun rollDice() {
        // Editable number of sides
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // Get Image View
        val diceImage: ImageView = findViewById(R.id.imageView)
        // Get Appropriate Dice Image Drawable Resource based on result of diceRoll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Set Image from Drawable Resource and set contentDescription for Accessibility
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
    }
}

class Dice(private val numOfSides: Int) {
    fun roll(): Int {
        return (1..numOfSides).random()
    }
}