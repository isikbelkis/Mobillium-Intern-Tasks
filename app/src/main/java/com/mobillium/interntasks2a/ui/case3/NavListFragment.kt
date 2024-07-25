package com.mobillium.interntasks2a.ui.case3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.mobillium.interntasks2a.adapter.WeatherAdapter
import com.mobillium.interntasks2a.databinding.FragmentNavListBinding
import com.mobillium.interntasks2a.util.CityData
import com.mobillium.interntasks2a.util.Constants

class NavListFragment : Fragment() {
    private lateinit var binding: FragmentNavListBinding
    private lateinit var adapter: WeatherAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentNavListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        setFragmentResultListener(Constants.REQUEST_KEY) { key, bundle ->
            val newTemperature = bundle.getInt(Constants.NEW_TEMPERATURE)
            val cityId = bundle.getString(Constants.CITY_ID)?.toInt()

            cityId?.let {
                adapter.updateCityTemperature(it, newTemperature)
            }
        }
    }

    private fun setupRecyclerView() {
        val cityData = CityData()
        val cities = cityData.getCity()

        adapter = WeatherAdapter(cities) { cityWeather ->
            val action =
                NavListFragmentDirections.actionNavListFragmentToNavDetailFragment(cityWeather)
            findNavController().navigate(action)
        }
        binding.fragmentNavRecyclerView.adapter = adapter
    }
}