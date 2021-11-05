package com.example.weatherapp.di

import com.example.weatherapp.data.remote.ApiService
import com.example.weatherapp.data.repo.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object DataRepoModule {

    @Provides
    fun provideDataRepo(apiService: ApiService): WeatherRepository {
        return WeatherRepository(apiService)
    }
}