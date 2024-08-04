package com.example.interntasks3.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.interntasks3.databinding.FragmentCounterBinding
import com.example.interntasks3.viewmodel.CounterViewModel

class CounterFragment : Fragment() {

    private lateinit var binding: FragmentCounterBinding
    private val viewModel: CounterViewModel by viewModels()
    private var uiCounter = 0
    private var useViewModelCounter = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCounterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateCounterTextView()

        with(binding) {
            viewModel.count1.observe(viewLifecycleOwner) { count ->
                if (useViewModelCounter) {
                    counterTextView.text = count.toString()
                }
            }

            switch1.setOnCheckedChangeListener { _, isChecked ->
                useViewModelCounter = isChecked
                updateCounterTextView()
            }

            incrementButton.setOnClickListener {
                if (useViewModelCounter) {
                    viewModel.incrementCount()
                } else {
                    uiCounter++
                    updateCounterTextView()
                }
            }
        }
    }

    private fun updateCounterTextView() {
        if (useViewModelCounter) {
            binding.counterTextView.text = viewModel.count1.value?.toString() ?: "0"
        } else {
            binding.counterTextView.text = uiCounter.toString()
        }
    }
}