package com.mobillium.interntasks2a.ui.case3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.mobillium.interntasks2a.R
import com.mobillium.interntasks2a.databinding.FragmentNavDetailBinding
import com.mobillium.interntasks2a.util.Constants

class NavDetailFragment : Fragment() {
    private lateinit var binding: FragmentNavDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNavDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: NavDetailFragmentArgs by navArgs()
        val cityWeather = args.cityWeather

        with(binding) {
            fragmentNavTemperatureText.text = cityWeather.temperature
            fragmentNavCityText.text = cityWeather.cityName
            fragmentNavWindSpeedText.text = cityWeather.cityName

            fragmentNavReflesh.setOnClickListener {
                val newTemperature = (Constants.MIN_TEMPERATURE..Constants.MAX_TEMPERATURE).random()
                fragmentNavTemperatureText.text = newTemperature.toString()
            }

            fragmentNavUpdateDataButton.setOnClickListener {
                val newTemperature = fragmentNavTemperatureText.text.toString().toInt()

                val resultBundle = Bundle().apply {
                    putInt(Constants.NEW_TEMPERATURE, newTemperature)
                    putString(Constants.CITY_ID, cityWeather.id.toString())
                }
                setFragmentResult(Constants.REQUEST_KEY, resultBundle)
                findNavController().popBackStack()
            }
        }
    }
}

