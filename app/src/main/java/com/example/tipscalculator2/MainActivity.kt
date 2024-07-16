package com.example.tipscalculator2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tipscalculator2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var percentage: Int = 0
        binding.rgOptionOne.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                percentage = 10
            }

            binding.rgOptionTwo.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    percentage = 15
                }

                binding.rgOptionThree.setOnCheckedChangeListener { _, isChecked ->
                    if (isChecked) {
                        percentage = 20
                    }
                }
            }
        }
        binding.btnClean.setOnClickListener {
            println("Joyce 1" + binding.tieTotal.text)
            println("Joyce 1" + binding.tieNumberOfPeople.text)
        }

        binding.btnCalculate.setOnClickListener {
            val totalTable: Float = binding.tieTotal.text.toString().toFloat()
            val nPeople: Int = binding.tieNumberOfPeople.text.toString().toInt()

            val totalTemp = totalTable / nPeople
            val tips = totalTemp * percentage
            val totalWithTips = totalTemp + tips
        }
    }
}