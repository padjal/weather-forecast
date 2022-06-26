package com.webdojobg.weatherforecast.ui.adapters

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.webdojobg.weatherforecast.R
import com.webdojobg.weatherforecast.data.models.WeatherInfo

class WeatherInfoAdapter (private var dataSet:List<WeatherInfo>) :
    RecyclerView.Adapter<WeatherInfoAdapter.WeatherInfoViewHolder>() {

    class WeatherInfoViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val imageView : ImageView = view.findViewById(R.id.image_weather)
        val coordsTextView : TextView = view.findViewById(R.id.text_coordinates)
        val temperatureTextView : TextView = view.findViewById(R.id.text_temperature)
        val humidityTextView : TextView = view.findViewById(R.id.text_humidity)
    }

    /**
     * Inflates the layout for each item int he recyclerview.
     *
     * @param parent
     * @param viewType
     * @return
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherInfoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.weather_info, parent, false)

        return WeatherInfoViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: WeatherInfoViewHolder, position: Int) {
        holder.coordsTextView.text = dataSet[position].coord.toString()
        holder.humidityTextView.text = "Humidity: ${dataSet[position].main.humidity.toString()}%"
        holder.temperatureTextView.text = "${dataSet[position].main.temp.toString()}° C"

        //TODO: Figure out how to display the correct image
    }

    override fun getItemCount() = dataSet?.count()

    fun updateData(newData : List<WeatherInfo>){
        dataSet = newData
        notifyDataSetChanged()
    }
}