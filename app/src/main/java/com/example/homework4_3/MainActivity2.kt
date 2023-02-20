package com.example.homework4_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main2)

            val name = intent?.getStringExtra(NAME)
            val phone = intent?.getStringExtra(PHONE)?.toLong() // инт короткий для номера
            val email = intent?.getStringExtra(EMAIL)
            val date = intent?.getStringExtra(DATE)
            //val sex = intent?.getStringExtra(SEX)

            val textView: TextView = findViewById(R.id.textView)
            textView.text = "  Your name: $name  \n  Your phone: $phone \n  Your email: $email \n" +
                    "  Your birthday: $date"
        }
}
/*
Взять активити из ДЗ №3 +
Введенные данные пользователя с помощью intent передать во вторую активи +
Используйте приведение типов (возраст и номер телефона передайте как int)+
Добавить radiobutton для выбора пола +
Добавить поле для ввода email (необходима валидация email)+
Добавить поле выбора даты рождения. При нажатии на поле открывается календарь +
Добавить кнопку для перехода на 3-юю активити +
При нажатии на кнопку должна открываться 3-яя активити +
С помощью intent передать в нее данные из первой и второй активити. +/-
Пол передать как параметр boolean означающий выбран женский пол или мужской
(например isMen или isFemail) +
В 3-ей активити отобразить переданные данные в таблице (как было в дз №3) +
В 3-ей активити в зависимости от выбранного пола применить стиль. +
 */