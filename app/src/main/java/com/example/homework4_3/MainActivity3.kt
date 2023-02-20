package com.example.homework4_3

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TableLayout
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val name = intent?.getStringExtra(NAME)
        val phone = intent?.getStringExtra(PHONE)
        val email = intent?.getStringExtra(EMAIL)
        val date = intent?.getStringExtra(DATE)
        val sex = intent?.getBooleanExtra("SEX", false)
        val table: TableLayout = findViewById(R.id.table1)
        if (sex == true) table.setBackgroundColor(Color.parseColor("#FF018786"))
            else table.setBackgroundColor(Color.parseColor("#FFF44336"))

        val textViewName: TextView = findViewById(R.id.textViewName)
        val textViewEmail: TextView = findViewById(R.id.textViewEmail)
        val textViewPhone: TextView = findViewById(R.id.textViewPhone)
        val textViewDate: TextView = findViewById(R.id.textViewBirthday)
        val textViewSex: TextView = findViewById(R.id.textViewSex)


        textViewName.text = "  $name"
        textViewPhone.text = "  $phone"
        textViewEmail.text = "  $email"
        textViewDate.text = "  $date"
        textViewSex.text = "  Are you male? - ${sex.toString()}"
    }
}