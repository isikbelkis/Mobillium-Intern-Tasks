package com.mobillium.interntasks2a.ui.case2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobillium.interntasks2a.R
import com.mobillium.interntasks2a.adapter.WeatherAdapter
import com.mobillium.interntasks2a.databinding.FragmentListBinding
import com.mobillium.interntasks2a.model.CityWeather
import com.mobillium.interntasks2a.util.CityData

class ListFragment : Fragment() {
    lateinit var binding: FragmentListBinding
    private lateinit var adapter: WeatherAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cities = CityData().getCity(requireContext())
        setupRecyclerView(cities)
    }

    private fun setupRecyclerView(cities: List<CityWeather>) {
        adapter = WeatherAdapter(cities) { city ->
            navigateToDetailFragment(city)
        }
        binding.fragmentRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.fragmentRecyclerView.adapter = adapter
    }

    private fun navigateToDetailFragment(city: CityWeather) {
        val detailFragment = DetailFragment()
        val bundle = Bundle().apply {
            putParcelable("cityWeather", city)
        }
        detailFragment.arguments = bundle

        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, detailFragment)
            .addToBackStack(null)
            .commit()
    }
}