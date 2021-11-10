package com.example.weatherapp.di

import com.example.weatherapp.data.remote.ApiService
import com.example.weatherapp.data.repo.ForecastRepository
import com.example.weatherapp.data.repo.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object DataRepoModule {

    @Provides
    fun provideWeatherRepo(apiService: ApiService): WeatherRepository {
        return WeatherRepository(apiService)
    }
    @Provides
    fun provideForecastRepo(apiService: ApiService): ForecastRepository {
        return ForecastRepository(apiService)
    }
}