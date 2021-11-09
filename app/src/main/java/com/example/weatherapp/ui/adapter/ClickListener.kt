package com.example.weatherapp.ui.adapter

import com.example.weatherapp.data.model.WeatherResponse

interface ClickListener {
    fun itemClicked(weather: WeatherResponse)
}