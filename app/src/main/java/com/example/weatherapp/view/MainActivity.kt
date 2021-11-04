package com.example.weatherapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.ActionBar
import com.example.weatherapp.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var etCity: TextInputEditText
    private lateinit var btnLookup: MaterialButton
    val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    val actionBar: ActionBar? by lazy { supportActionBar }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initUI()
    }

    fun initUI() {
        actionBar?.hide()
        setContentView(binding.root)
        etCity = binding.etCityName
        btnLookup = binding.btnLookup
    }
}