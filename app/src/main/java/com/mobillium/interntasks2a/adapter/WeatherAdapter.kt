package com.mobillium.interntasks2a.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mobillium.interntasks2a.databinding.RecyclerCityCardBinding
import com.mobillium.interntasks2a.model.CityWeather

class WeatherAdapter(
    val CityWeatherList: MutableList<CityWeather>,
    //Tıklama
    val onItemClickListener: (CityWeather) -> Unit
) : RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    class ViewHolder(val binding: RecyclerCityCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CityWeather, onItemClickListener: (CityWeather) -> Unit) {
            binding.cityNameText.text = item.cityName
            binding.temperatureText1.text = item.temperature
            binding.temperatureRangesText5.text = item.temperatureMinMax
            binding.sunnyText.text = item.weatherName
            binding.imageSunny.setImageResource(item.weatherImage)
            itemView.setOnClickListener { onItemClickListener(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val ViewHolderAdapter = RecyclerCityCardBinding
            .inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(ViewHolderAdapter)
    }

    override fun getItemCount(): Int {
        return CityWeatherList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(CityWeatherList[position], onItemClickListener)
    }
}