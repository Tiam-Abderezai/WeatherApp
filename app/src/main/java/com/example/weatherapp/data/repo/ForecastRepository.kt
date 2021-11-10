package com.example.weatherapp.data.repo

import com.example.weatherapp.data.model.ForecastResponse
import com.example.weatherapp.data.remote.ApiService
import retrofit2.Response
import javax.inject.Inject

class ForecastRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getForecast(city: String, api_key: String): Response<ForecastResponse> {
        return apiService.getForecast(city, api_key)
    }
}