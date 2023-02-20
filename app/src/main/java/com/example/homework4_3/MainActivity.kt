package com.example.homework4_3

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Calendar

const val NAME = "name"
const val PHONE = "phone"
const val EMAIL = "email"
const val DATE = "date"

class MainActivity : AppCompatActivity() {

    var etName: EditText? = null
    var etPhone: EditText? = null
    var etEmail: EditText? = null
    var etDate: EditText? = null
    var btnR1: Button? = null
    var btnR2: Button? = null
    var btn: Button? = null

    private val textWatcher: TextWatcher = object: TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            val nameFilled = etName?.text.toString()
            val phoneFilled = etPhone?.text.toString()
            val emailFilled = etEmail?.text.toString()
            val dateFilled = etDate?.text.toString() // виджет календаря открывается только после второго клика, не знаю почему, может в xml нужно что-то поправить

            btn?.setEnabled(!nameFilled.isEmpty() && !phoneFilled.isEmpty() && !emailFilled.isEmpty() && emailFilled.isValidEmail() && !dateFilled.isEmpty())
        }

        override fun afterTextChanged(s: Editable?) {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myCalendar = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            writeLabel(myCalendar)
        }
        val intentToAnotherScreen = Intent(applicationContext, MainActivity2::class.java)

        etName = findViewById(R.id.editTextTextPersonName)
        etPhone = findViewById(R.id.editTextPhone)
        etEmail = findViewById(R.id.editTextEmail)
        etDate = findViewById(R.id.editTextDate)
        btn = findViewById(R.id.button)
        btnR1 = findViewById(R.id.radioButton)
        btnR2 = findViewById(R.id.radioButton2)

        this.etName?.addTextChangedListener(textWatcher)
        this.etPhone?.addTextChangedListener(textWatcher)
        this.etEmail?.addTextChangedListener(textWatcher)
        this.etDate?.addTextChangedListener(textWatcher)

        etDate?.setOnClickListener{
            DatePickerDialog(this, datePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }

        btn?.setOnClickListener {
            intentToAnotherScreen.putExtra(NAME,etName?.text.toString())
            intentToAnotherScreen.putExtra(PHONE, etPhone?.text.toString())
            intentToAnotherScreen.putExtra(EMAIL, etEmail?.text.toString())
            intentToAnotherScreen.putExtra(DATE, etDate?.text.toString())
            startActivity(intentToAnotherScreen)
            Toast.makeText(this@MainActivity, "Do you fill all fields on preview screen?", Toast.LENGTH_LONG).show()
        }



    }

    private fun writeLabel(myCalendar: Calendar) {
        val myFormat = "dd-MMMM-yyyy"
        val simpleDF = SimpleDateFormat(myFormat)
        etDate?.setText((simpleDF.format(myCalendar.time)))
    }

    fun CharSequence?.isValidEmail() = !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

}

/*
Взять активити из ДЗ №3
Введенные данные пользователя с помощью intent передать во вторую активи
Используйте приведение типов (возраст и номер телефона передайте как int)
Добавить radiobutton для выбора пола
Добавить поле добавить поле для ввода email (необходима валидация email)
Добавить поле выбора даты рождения. При нажатии на поле открывается календарь
Добавить кнопку для перехода на 3-юю активити
При нажатии на кнопку должна открываться 3-яя активити
С помощью intent передать в нее данные из первой и второй активити.
Пол передать как параметр boolean означающий выбран женский пол или мужской
(например isMen или isFemail)
В 3-ей активити отобразить переданные данные в таблице (как было в дз №3)
В 3-ей активити в зависимости от выбранного пола применить стиль.
 */