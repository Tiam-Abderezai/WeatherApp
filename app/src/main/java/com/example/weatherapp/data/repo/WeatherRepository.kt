package com.example.weatherapp.data.repo

import android.database.Observable
import com.example.weatherapp.data.model.Weather
import com.example.weatherapp.data.model.WeatherResponse
import com.example.weatherapp.data.remote.ApiService
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getWeather(city: String, api_key: String): Response<WeatherResponse> {
        return apiService.getWeather(city, api_key)
    }
    suspend fun getForecast(city: String, api_key: String): Response<WeatherResponse> {
        return apiService.getForecast(city, api_key)
    }
}