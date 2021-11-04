package com.example.weatherapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.weatherapp.data.repo.WeatherRepository
import com.example.weatherapp.utils.Resource
import kotlinx.coroutines.Dispatchers

class WeatherViewModel constructor(
    private val weatherRepo: WeatherRepository
) : ViewModel() {
    fun fetchWeatherData() = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(data = weatherRepo.getWeatherData()))
        } catch (exception: Exception) {
            emit(Resource.error(exception.message ?: "Error Occurred!", data = null))
        }
    }
}