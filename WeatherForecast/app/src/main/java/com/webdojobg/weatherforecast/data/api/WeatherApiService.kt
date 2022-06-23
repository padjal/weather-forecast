package com.webdojobg.weatherforecast.data.api

import com.webdojobg.weatherforecast.data.models.WeatherInfo
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    companion object{
        const val BASE_URL = "https://api.openweathermap.org/"
    }

    @GET("data/2.5/weather")
    suspend fun getWeatherInfo(
        @Query("lat") lat:Int,
        @Query("lon") lon:Int,
        @Query("appid") apiKey : String
    ) : WeatherInfo
}