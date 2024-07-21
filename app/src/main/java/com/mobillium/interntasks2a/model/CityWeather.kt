package com.mobillium.interntasks2a.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CityWeather(
    val id: Int,
    val cityName: String,
    val temperature: String,
    val temperatureMinMax: String,
    val weatherName: String,
    val weatherImage: Int
) : Parcelable {
}