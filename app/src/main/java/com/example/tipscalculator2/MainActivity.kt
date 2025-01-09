package com.example.tipscalculator2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tipscalculator2.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener {
            val totalTableTemp = binding.tieTotal.text
            val nPeopleTemp = binding.tieNumberOfPeople.text
            val percentageTemp = binding.tiePercentage.text

            if (totalTableTemp?.isEmpty() == true ||
                nPeopleTemp?.isEmpty() == true ||
                    percentageTemp?.isEmpty() == true
            ) {
                Snackbar
                    .make(binding.tieTotal, "Fill in all the fields", Snackbar.LENGTH_LONG)
                    .show()
            } else {
                val totalTable: Float = totalTableTemp.toString().toFloat()
                val nPeople: Int = nPeopleTemp.toString().toInt()
                val percentage: Int = percentageTemp.toString().toInt()
                val totalTemp = totalTable / nPeople
                val tips = totalTemp * percentageTemp.toString().toInt() / 100
                val totalWithTips = totalTemp + tips


                val intent = Intent(this, SummaryActivity::class.java)
                intent.apply {
                    putExtra("totalTable", totalTable)
                    putExtra("percentage", percentage)
                    putExtra("numPeople",nPeople)
                    putExtra("totalAmount", totalWithTips)
                }
                clean()
                startActivity(intent)
            }
        }

        // Botão "Limpar"
        binding.btnClean.setOnClickListener {
       clean()
        }
    }

    private fun clean(){
        binding.tieTotal.setText("")
        binding.tiePercentage.setText("")
        binding.tieNumberOfPeople.setText("")
    }
}