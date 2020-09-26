package dev.fummicc1.sample.dice_roller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var number: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)

        rollButton.setOnClickListener {
            rollDice()
        }

        val countUpButton: Button = findViewById(R.id.count_up_button)
        countUpButton.setOnClickListener {
            countUp()
        }
    }

    private fun rollDice() {
        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()

        val resultTextView: TextView = findViewById(R.id.result_text)
        val random = (1..6).random()
        resultTextView.text = random.toString()

        number = random
    }

    private  fun countUp() {
        if (number == 6) {
            return
        }
        number += 1
        val resultTextView: TextView = findViewById(R.id.result_text)
        resultTextView.text = number.toString()
    }
}