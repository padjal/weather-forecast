package com.webdojobg.weatherforecast.data.sources

import android.util.Log
import com.webdojobg.weatherforecast.data.api.WeatherApiService
import com.webdojobg.weatherforecast.models.WeatherInfo
import retrofit2.Retrofit
import java.lang.Exception
import javax.inject.Inject

// Gets weather info from an API
class WeatherDataSource @Inject constructor(val weatherApiService: WeatherApiService) {
    suspend fun fetchLatestWeather(): List<WeatherInfo> {
        val weatherInfo = ArrayList<WeatherInfo>()

        val response = weatherApiService.getWeatherInfo(35, 139, "7bc83dc4cd55081f4d8c056e0191d037")

        weatherInfo.add(response)

        return weatherInfo
    }
}