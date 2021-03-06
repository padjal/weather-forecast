package com.webdojobg.weatherforecast.ui.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.webdojobg.weatherforecast.data.repositories.WeatherRepository
import com.webdojobg.weatherforecast.data.models.WeatherInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel(){
    val weatherLiveData = MutableLiveData<List<WeatherInfo>>()
    init {
        weatherLiveData.value = ArrayList<WeatherInfo>()
    }

    init {
        viewModelScope.launch {
            weatherRepository.latestWeatherInfo.collect {
                    value: List<WeatherInfo> ->
                weatherLiveData.value = value
                Log.i("Something", value.toString())
            }
        }
    }
}