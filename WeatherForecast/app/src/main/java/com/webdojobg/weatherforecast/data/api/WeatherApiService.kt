package com.webdojobg.weatherforecast.data.api

import android.media.Image
import com.webdojobg.weatherforecast.data.models.WeatherInfo
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApiService {
    companion object{
        const val BASE_URL = "https://api.openweathermap.org/"
    }

    /**
     * Gets weather info for specified coordinates.
     *
     * @param lat The latitude of the location.
     * @param lon The longitude of the location.
     * @param apiKey The api key used to connect to Open Weather Map.
     * @return Current weather info for the given locations. Info includes temperature, humidity,
     * description and much more. See @seeWeatherInfo.
     */
    @GET("data/2.5/weather")
    suspend fun getWeatherInfo(
        @Query("lat") lat:Int,
        @Query("lon") lon:Int,
        @Query("appid") apiKey : String,
        @Query("units") units : String = "metric"
    ) : WeatherInfo

    /**
     * Gets an icon based on the icon name.
     *
     * @param iconName The searched icon.
     * @return
     */
    @GET("img/wn/{iconName}@4x.png")
    suspend fun getWeatherIcon(
        @Path("iconName") iconName : String
    ) : Call<ResponseBody>
}