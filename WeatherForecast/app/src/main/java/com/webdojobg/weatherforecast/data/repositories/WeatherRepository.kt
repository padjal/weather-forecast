package com.webdojobg.weatherforecast.data.repositories

import com.webdojobg.weatherforecast.data.sources.WeatherDataSource
import com.webdojobg.weatherforecast.models.WeatherInfo
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val weatherApiDataSource : WeatherDataSource, // network api

        ){
    private val REFRESH_INTERVAL_MS : Long = 5000

    val latestWeatherInfo: Flow<List<WeatherInfo>> = flow {
        while(true){
            val latestWeatherInfo = weatherApiDataSource.fetchLatestWeather();
            emit(latestWeatherInfo)
            delay(REFRESH_INTERVAL_MS)
        }
    }
}