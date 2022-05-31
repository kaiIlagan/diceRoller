package com.example.diceroller

// Imports required for program use
import android.os.Bundle
import android.widget.Button
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
    }


    private fun rollDice() {
        // Editable number of sides
        val dice = Dice(6)
        val diceRoll = dice.roll()
    }
}

class Dice(private val numOfSides: Int) {
    fun roll(): Int {
        return (1..numOfSides).random()
    }
}