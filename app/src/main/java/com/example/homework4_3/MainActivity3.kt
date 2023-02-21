package com.example.homework4_3

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TableLayout
import android.widget.TextView
import android.widget.Toast

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

        textViewEmail.setOnClickListener {
            val emailIntent= Intent().apply { //не знаю какой код лучше читаем: этот или для телефона
                action=Intent.ACTION_SEND
                data= Uri.parse("mailto:")
                type="text/plain"
                putExtra(Intent.EXTRA_EMAIL,arrayOf(textViewEmail.text.toString()))
                putExtra(Intent.EXTRA_SUBJECT,"I want to send you email")
            }
            if (emailIntent.resolveActivity(this.packageManager) !=null){
                emailIntent.setPackage("com.google.android.gm")
                startActivity(emailIntent)
            }else{
                Toast.makeText(this@MainActivity3,"No app available to send email!!", Toast.LENGTH_SHORT).show()
            }
        }

        textViewPhone.setOnClickListener(View.OnClickListener { //этот код тоже простой
            val phoneIntent = Intent(Intent.ACTION_DIAL)
            phoneIntent.data = Uri.parse("tel:" +textViewPhone.text.toString())
            startActivity(phoneIntent)
//            if (phoneIntent.resolveActivity(this.packageManager) != null)   с проверкой не запускается... не знаю почему
//                startActivity(phoneIntent)
//            else Toast.makeText(this@MainActivity3,"No app available to make call!!", Toast.LENGTH_SHORT).show()
        })

    }
}
/*
В 3-ей активити реализовать вызовы неявных интентов:
При нажатии на номер телефона должно открыть приложение звонков +
При нажатии на email должно открыться приложение почты. Введенный пользователем email +
должен быть передан как адрес отправителя
 */