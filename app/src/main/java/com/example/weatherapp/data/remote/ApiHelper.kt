package com.example.weatherapp.data.remote


class ApiHelper  constructor(private val apiService: ApiService) {
    suspend fun getWeatherData() = apiService.getWeatherData()
}