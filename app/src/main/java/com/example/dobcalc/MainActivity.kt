package com.example.dobcalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dobcalc.databinding.ActivityMainBinding
import org.threeten.bp.OffsetDateTime

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnSelectDate.setOnClickListener {
            clickDatePicker()
        }
    }

    fun clickDatePicker() {
        val calendar = OffsetDateTime.now()
        val year = calendar.year
        val month = calendar.monthValue
        val day = calendar.dayOfMonth
        DatePickerDialog(
            this,
            { view, year, month, dayOfMonth -> },
            year,
            month,
            day
        ).show()
    }
}