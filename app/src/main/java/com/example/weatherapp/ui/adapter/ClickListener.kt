package com.example.weatherapp.ui.adapter

import com.example.weatherapp.data.model.WeatherResponse
import retrofit2.Response

interface ClickListener {
    fun itemClicked(weather:
                    Response<WeatherResponse>
    )
}