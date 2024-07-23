package com.mobillium.interntasks2a.ui.case2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mobillium.interntasks2a.R
import com.mobillium.interntasks2a.databinding.FragmentDetailBinding
import com.mobillium.interntasks2a.model.CityWeather

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val city = arguments?.getParcelable<CityWeather>("cityWeather")
        city?.let {
            binding.fragmentCityText.text = it.cityName
            binding.fragmentTemperatureText.text = it.temperature
            binding.fragmentWeatherNameText.text = it.weatherName
            binding.fragmentWeatherImage.setImageResource(it.weatherImage)
        }
    }
}