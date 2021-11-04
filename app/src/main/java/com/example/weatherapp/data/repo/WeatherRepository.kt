package com.example.weatherapp.data.repo

import com.example.weatherapp.data.model.Weather
import com.example.weatherapp.data.remote.ApiService

class WeatherRepository constructor(private val apiService: ApiService) {
    suspend fun getWeatherData(): List<Weather> {
        return apiService.getWeatherData()
    }
}