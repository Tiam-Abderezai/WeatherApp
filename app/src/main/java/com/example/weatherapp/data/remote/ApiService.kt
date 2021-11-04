package com.example.weatherapp.data.remote

import com.example.weatherapp.data.model.Weather

interface ApiService {
//    @GET("cats?count=100&urls=true&httpsUrls=true")
    suspend fun getWeatherData(): List<Weather>
}