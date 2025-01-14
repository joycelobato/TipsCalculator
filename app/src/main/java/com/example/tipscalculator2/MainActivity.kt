package com.example.tipscalculator2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tipscalculator2.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Habilita o modo Edge-to-Edge
        enableEdgeToEdge()

        // Inicializa o layout com View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configura o layout para aplicar as inserções de barras do sistema
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets // Retorna as inserções corretamente
        }

        // Configura o botão de cálculo
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

                // Cria a Intent para a SummaryActivity
                val intent = Intent(this, SummaryActivity::class.java)
                intent.apply {
                    putExtra("totalTable", totalTable)
                    putExtra("percentage", percentage)
                    putExtra("numPeople", nPeople)
                    putExtra("totalAmount", totalWithTips)
                }

                clean() // Limpa os campos
                startActivity(intent) // Inicia a SummaryActivity
            }
        }

        // Botão "Limpar"
        binding.btnClean.setOnClickListener {
            clean()
        }
    }

    // Função para limpar os campos
    private fun clean() {
        binding.tieTotal.setText("")
        binding.tiePercentage.setText("")
        binding.tieNumberOfPeople.setText("")
    }
}
