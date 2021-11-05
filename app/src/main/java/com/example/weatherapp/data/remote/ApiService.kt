package com.example.weatherapp.data.remote

import com.example.weatherapp.data.model.Weather
import retrofit2.http.GET

interface ApiService {
    @GET("cats?count=100&urls=true&httpsUrls=true")
    suspend fun getWeatherData(): List<Weather>
}