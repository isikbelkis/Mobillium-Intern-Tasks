package com.mobillium.interntasks2a.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobillium.interntasks2a.databinding.RecyclerCityCardBinding
import com.mobillium.interntasks2a.model.CityWeather

class WeatherAdapter(
    val cityWeatherList: List<CityWeather>,
    val onItemClickListener: (CityWeather) -> Unit
) : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    class ViewHolder(val binding: RecyclerCityCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(cityWeather: CityWeather, onItemClickListener: (CityWeather) -> Unit) {
            with(binding) {
                cityNameText.text = cityWeather.cityName
                temperatureText1.text = cityWeather.temperature
                temperatureRangesText5.text = cityWeather.temperatureMinMax
                sunnyText.text = cityWeather.weatherName
                imageSunny.setImageResource(cityWeather.weatherImage)
                root.setOnClickListener { onItemClickListener(cityWeather) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHolderAdapter = RecyclerCityCardBinding
            .inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(viewHolderAdapter)
    }

    override fun getItemCount(): Int {
        return cityWeatherList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cityWeatherList[position], onItemClickListener)
    }

    fun updateCityTemperature(cityId: Int?, newTemperature: Int) {
        cityId?.let { id ->
            for (city in cityWeatherList) {
                if (city.id == id) {
                    city.temperature = newTemperature.toString()
                    notifyDataSetChanged()
                    break
                }
            }
        }
    }
}
