package com.mobillium.interntasks2a.ui.case1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mobillium.interntasks2a.adapter.WeatherAdapter
import com.mobillium.interntasks2a.databinding.ActivityListBinding
import com.mobillium.interntasks2a.model.CityWeather
import com.mobillium.interntasks2a.util.CityData
import com.mobillium.interntasks2a.util.Constants

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding
    private lateinit var adapter: WeatherAdapter
    private lateinit var cityWeatherList: MutableList<CityWeather>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cityWeatherList = CityData().getCity()

        adapter = WeatherAdapter(cityWeatherList) { cityWeather ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra(Constants.CITY_WEATHER, cityWeather)
            }
            startActivity(intent)
        }
        binding.recyclerView.adapter = adapter
    }
}