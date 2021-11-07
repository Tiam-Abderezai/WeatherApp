package com.example.weatherapp.data.repo

import com.example.weatherapp.data.model.Weather
import com.example.weatherapp.data.remote.ApiService
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getWeather(city: String, api_key: String): List<Weather> {
        return apiService.getWeather(city, api_key)
    }
}