package com.orellana.labo04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameEditText = findViewById<EditText>(R.id.insertName)
        val emailEditText = findViewById<EditText>(R.id.insertEmail)
        val phoneEditText = findViewById<EditText>(R.id.insertPhone)

        val saveButton = findViewById<Button>(R.id.saveButton)

        saveButton.setOnClickListener{
            val nameValue = nameEditText.text.toString()
            val emailValue = emailEditText.text.toString()
            val numberValue = phoneEditText.text.toString()

            val confirmActivityIntent = Intent(this, ConfirmActivity::class.java)
            confirmActivityIntent.putExtra("Nombre", nameValue)
            confirmActivityIntent.putExtra("correo", emailValue)
            confirmActivityIntent.putExtra("teléfono", numberValue)

            startActivity(confirmActivityIntent)

        }

    }
}