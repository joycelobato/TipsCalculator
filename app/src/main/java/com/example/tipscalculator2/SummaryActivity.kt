package com.example.tipscalculator2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tipscalculator2.databinding.ActivitySummaryBinding

class SummaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Ativa o modo Edge-to-Edge
        enableEdgeToEdge()
        setContentView(R.layout.activity_summary)

        // Inicializa o layout com View Binding
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

       // Configura os dados recebidos via Intent
        val totalTable = intent.getFloatExtra("totalTable", 0.0f)
        val nPeople = intent.getIntExtra("numPeople", 0)
        val percentage = intent.getIntExtra("percentage", 0)
        val totalWithTips = intent.getFloatExtra("totalAmount", 0.0f)

        binding.tvPercentage.text = "$percentage%"
        binding.tvAmount.text = "$$totalWithTips"
        binding.tvTotalTable.text = totalTable.toString()
        binding.tvNumPeopleTable.text = nPeople.toString()

        // Configura o botão de refresh
        binding.btnRefresh.setOnClickListener {
            finish()
        }

        // Ajusta os paddings do layout com base nas barras de sistema
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
