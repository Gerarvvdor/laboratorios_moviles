package com.orellana.labo04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ConfirmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_data)


        val nameView = findViewById<TextView>(R.id.nameTextiew)
        val emailVIew = findViewById<TextView>(R.id.mailTextView)
        val numberView = findViewById<TextView>(R.id.numberTextView)

        val shareButton = findViewById<Button>(R.id.shareButton)

        val nameValue = intent.getStringExtra("nombre")
        val emailValue = intent.getStringExtra("correo")
        val phoneValue = intent.getStringExtra("telefono")

        nameView.text = nameValue
        emailVIew.text = emailValue
        numberView.text = phoneValue

        shareButton.setOnClickListener{
            val shareIntent = Intent(Intent.ACTION_SEND)

            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Name: $nameValue \nEmail: $emailValue \nCellphone: $phoneValue ")

            startActivity(Intent.createChooser(shareIntent, "Share to:"))
        }

    }
}
