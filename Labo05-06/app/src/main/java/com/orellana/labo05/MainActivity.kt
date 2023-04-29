package com.orellana.labo05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels


class MainActivity : AppCompatActivity() {

    private val viewModel:MovieViewModel by viewModels {
        MovieViewModel.Factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}