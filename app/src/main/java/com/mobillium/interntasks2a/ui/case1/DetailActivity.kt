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

        //gelen verileri alıyoruz
        val cityWeather = intent.getParcelableExtra<CityWeather>("cityWeather")

        //ui elemanlarına set ediyoruz
        cityWeather?.let {
            binding.cityText.text = it.cityName
            binding.weatherImage.setImageResource(it.weatherImage)
            binding.weatherNameText.text = it.weatherName
            binding.temperatureText.text = it.temperature
            binding.temperatureRangesText.text = it.temperatureMinMax
            binding.temperatureRangesText2.text = it.temperatureMinMax
            binding.temperatureRangesText3.text = it.temperatureMinMax
            binding.temperatureRangesText4.text = it.temperatureMinMax
        }
    }
}