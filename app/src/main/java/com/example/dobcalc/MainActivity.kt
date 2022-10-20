package com.example.dobcalc

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.dobcalc.databinding.ActivityMainBinding
import org.threeten.bp.OffsetDateTime
import java.text.SimpleDateFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tvTitle4.visibility = View.INVISIBLE
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
            { view, selectedYear, selectedMonth, selectedDayOfMonth ->
                binding.tvTitle4.text =
                    getString(R.string.tv_title_4, selectedDayOfMonth, selectedMonth, selectedYear)
                binding.tvTitle4.visibility = View.VISIBLE

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ITALY)

                val date = sdf.parse(binding.tvTitle4.text.toString())
                Log.v("Main ACtivity", "$date")
            },
            year,
            month,
            day
        ).show()
    }
}