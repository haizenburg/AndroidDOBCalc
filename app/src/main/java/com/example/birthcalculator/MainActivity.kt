package com.example.birthcalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private var tvSelectedDate : TextView? = null;
    private var tvInMinutes : TextView? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker = findViewById<Button>(R.id.btnDatePicker)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        tvInMinutes = findViewById(R.id.tvInMinutes)

        btnDatePicker.setOnClickListener{
           clickDatePicker()
        }
    }


    private fun clickDatePicker() {

        val myCal = Calendar.getInstance()
        val year = myCal.get(Calendar.YEAR)
        val month = myCal.get(Calendar.MONTH)
        val day = myCal.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                Toast.makeText(this, "year was $year pressed", Toast.LENGTH_LONG).show()


                val selectedDate = "$dayOfMonth/${month+1}/$year"

                tvSelectedDate?.text = selectedDate;

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val theDate = sdf.parse(selectedDate)

                val selectedDateInMinutes = theDate.time / 60000

                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                val currentDateInMinutes = currentDate.time/60000

                val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes

                tvInMinutes?.text = differenceInMinutes.toString()

            },
            year,
            month,
            day,
        ).show()

//        DatePickerDialog()

        Toast.makeText(this, "btnDate pressed", Toast.LENGTH_LONG).show()
    }
}