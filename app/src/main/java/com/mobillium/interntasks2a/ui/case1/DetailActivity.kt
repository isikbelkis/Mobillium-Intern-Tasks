package com.mobillium.interntasks2a.ui.case1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobillium.interntasks2a.databinding.ActivityDetailBinding
import com.mobillium.interntasks2a.model.CityWeather

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cityWeather = intent.getParcelableExtra<CityWeather>("cityWeather")

        cityWeather?.let { weather ->
            with(binding) {
                cityText.text = weather.cityName
                weatherImage.setImageResource(weather.weatherImage)
                weatherNameText.text = weather.weatherName
                temperatureText.text = weather.temperature
                temperatureRangesText.text = weather.temperatureMinMax
                temperatureRangesText2.text = weather.temperatureMinMax
                temperatureRangesText3.text = weather.temperatureMinMax
                temperatureRangesText4.text = weather.temperatureMinMax
            }
        }
    }
}