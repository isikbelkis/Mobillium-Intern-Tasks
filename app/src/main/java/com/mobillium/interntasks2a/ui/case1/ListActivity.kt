package com.mobillium.interntasks2a.ui.case1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobillium.interntasks2a.adapter.WeatherAdapter
import com.mobillium.interntasks2a.databinding.ActivityListBinding
import com.mobillium.interntasks2a.model.CityWeather
import com.mobillium.interntasks2a.util.CityData

class ListActivity : AppCompatActivity() {
    lateinit var binding: ActivityListBinding
    lateinit var adapter: WeatherAdapter
    lateinit var cityWeatherList: MutableList<CityWeather>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cityWeatherList = CityData().getCity(this)

        adapter = WeatherAdapter(cityWeatherList) { CityWeather ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("cityWeather", CityWeather)
            }
            startActivity(intent)
        }
        binding.recyclerView.adapter = adapter
    }
}