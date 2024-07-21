package com.mobillium.interntasks2a.util

import android.content.Context
import com.mobillium.interntasks2a.R
import com.mobillium.interntasks2a.model.CityWeather

class CityData {
    fun getCity(context: Context): MutableList<CityWeather> {
        return mutableListOf(
            CityWeather(
                id = 1,
                cityName = "İstanbul",
                temperature = "26",
                temperatureMinMax = "14°-27°",
                weatherName = "Güneşli",
                weatherImage = R.drawable.ic_sunny
            ),
            CityWeather(
                id = 2,
                cityName = "Ankara",
                temperature = "26",
                temperatureMinMax = "14°-27°",
                weatherName = "Güneşli",
                weatherImage = R.drawable.ic_sunny
            ),
            CityWeather(
                id = 3,
                cityName = "Erzurum",
                temperature = "26",
                temperatureMinMax = "14°-27°",
                weatherName = "Güneşli",
                weatherImage = R.drawable.ic_sunny
            ),
            CityWeather(
                id = 4,
                cityName = "Sakarya",
                temperature = "26",
                temperatureMinMax = "14°-27°",
                weatherName = "Güneşli",
                weatherImage = R.drawable.ic_sunny
            )
        )
    }
}