package com.webdojobg.weatherforecast.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.webdojobg.weatherforecast.R
import com.webdojobg.weatherforecast.databinding.ActivityMainBinding
import com.webdojobg.weatherforecast.ui.adapters.WeatherInfoAdapter
import com.webdojobg.weatherforecast.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val model:MainViewModel by viewModels()
        
        val weatherInfoAdapter = WeatherInfoAdapter(model.weatherLiveData.value!!)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = weatherInfoAdapter

        model.weatherLiveData.observe(this) { weatherData ->
            weatherData?.let {
                weatherInfoAdapter.updateData(it)
            }
        }
    }
}