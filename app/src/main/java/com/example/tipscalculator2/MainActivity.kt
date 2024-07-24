
package com.example.tipscalculator2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tipscalculator2.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var percentage = 0
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


        binding.btnCalculate.setOnClickListener {
            val totalTableTemp = binding.tieTotal.text
            val nPeopleTemp = binding.tieNumberOfPeople.text

            if (totalTableTemp?.isEmpty() == true ||
                nPeopleTemp?.isEmpty() == true

            ) {

                Snackbar
                    .make(binding.tieTotal, "Preencha todos os campos", Snackbar.LENGTH_LONG)
                    .show()


            } else {
                val totalTable: Float = totalTableTemp.toString().toFloat()
                val nPeople: Int = nPeopleTemp.toString().toInt()

                val totalTemp = totalTable / nPeople
                val tips = totalTemp * percentage / 100
                val totalWithTips = totalTemp + tips
                binding.tvResult.text = "Total com gorjetas $$totalWithTips"
            }
            binding.btnClean.setOnClickListener {
                binding.tvResult.text = ""
                binding.tieTotal.setText("")
                binding.tieNumberOfPeople.setText("")
                binding.rgOptionOne.isChecked = false
                binding.rgOptionTwo.isChecked = false
                binding.rgOptionThree.isChecked = false
            }
        }
    }
}
