package com.webdojobg.weatherforecast.data.sources

import android.util.Log
import com.webdojobg.weatherforecast.data.api.WeatherApiService
import com.webdojobg.weatherforecast.data.models.WeatherInfo
import javax.inject.Inject

// Gets weather info from an API
class WeatherDataSource @Inject constructor(val weatherApiService: WeatherApiService) {
    private val API_KEY = "7bc83dc4cd55081f4d8c056e0191d037"

    private val locations = setOf(
        WeatherInfo.Coord(139.0,35.0),
        WeatherInfo.Coord(42.7, 23.2),
        WeatherInfo.Coord(55.6, 36.8)

    )

    suspend fun fetchLatestWeather(): List<WeatherInfo> {
        val weatherInfo = ArrayList<WeatherInfo>()

        for (location in locations) {
            val response = weatherApiService.getWeatherInfo(location.lat.toInt(), location.lon.toInt(), API_KEY)

            weatherInfo.add(response)

            Log.i("WeatherInfo", "Weather data for coordinates ${response.coord} received.")
        }

        return weatherInfo
    }
}