package com.example.interntasks3.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.interntasks3.databinding.FragmentNavigateBinding

class NavigateFragment : Fragment() {

    private lateinit var binding: FragmentNavigateBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNavigateBinding.inflate(inflater, container, false)

        binding.buttonCounterFragment.setOnClickListener {
            val action = NavigateFragmentDirections.actionNavigateFragmentToCounterFragment()
            findNavController().navigate(action)
        }

        binding.buttonGuessFragment.setOnClickListener {
            val action = NavigateFragmentDirections.actionNavigateFragmentToGuessGameFragment()
            findNavController().navigate(action)
        }
        return binding.root
    }
}