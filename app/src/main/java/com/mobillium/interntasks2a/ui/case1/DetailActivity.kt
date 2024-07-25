package com.mobillium.interntasks2a.ui.case1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobillium.interntasks2a.databinding.ActivityDetailBinding
import com.mobillium.interntasks2a.model.CityWeather
import com.mobillium.interntasks2a.util.Constants

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cityWeather = intent.getParcelableExtra<CityWeather>(Constants.CITY_WEATHER)

        cityWeather?.let { weather ->
            with(binding) {
                cityText.text = weather.cityName
                weatherImage.setImageResource(weather.weatherImage)
                weatherNameText.text = weather.weatherName
                temperatureText.text = weather.temperature
            }
        }
    }
}