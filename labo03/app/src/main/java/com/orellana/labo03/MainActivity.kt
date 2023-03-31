package com.orellana.labo03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView


private lateinit var count_text_view: TextView
private lateinit var five_cents_image_view : ImageView
private lateinit var ten_cents_image_view : ImageView
private lateinit var quarter_image_view : ImageView
private lateinit var one_dollar_image_view : ImageView

var result = 0.0
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        count_text_view = findViewById(R.id.counter_text)
        five_cents_image_view = findViewById(R.id.fiveCents)
        ten_cents_image_view = findViewById(R.id.tenCents)
        quarter_image_view = findViewById(R.id.quarter)
        one_dollar_image_view = findViewById(R.id.oneDollar)

        calculate()


    }
}


private fun calculate() {
    five_cents_image_view.setOnClickListener{
        result += 0.05
        count_text_view.text = result.toString()
    }

    ten_cents_image_view.setOnClickListener {
        result += 0.10
        count_text_view.text = result.toString()
    }

    quarter_image_view.setOnClickListener{
        result += 0.25
        count_text_view.text = result.toString()
    }
    one_dollar_image_view.setOnClickListener{
        result += 1.00
        count_text_view.text = result.toString()
    }
}





