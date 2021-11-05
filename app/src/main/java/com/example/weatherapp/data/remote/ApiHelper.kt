package com.example.weatherapp.data.remote

import javax.inject.Inject

class ApiHelper @Inject constructor(private val apiService: ApiService) {
    suspend fun getWeatherData() = apiService.getWeatherData()
}