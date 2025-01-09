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
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val totalTable = intent.getFloatExtra("totalTable",0.0f)
        val nPeople = intent.getIntExtra("numPeople",0)
        val percentage = intent.getIntExtra("percentage",0)
        val totalWithTips = intent.getFloatExtra("totalAmount",0.0f)

        binding.tvPercentage.text = percentage.toString() + "%"
        binding.tvAmount.text = "$" + totalWithTips.toString()
        binding.tvTotalTable.text = totalTable.toString()
        binding.tvNumPeopleTable.text = nPeople.toString()

        binding.btnRefresh.setOnClickListener{
            finish()
        }    }
}

