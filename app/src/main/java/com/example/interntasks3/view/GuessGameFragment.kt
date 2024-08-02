package com.example.interntasks3.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.interntasks3.databinding.FragmentGuessGameBinding
import com.example.interntasks3.viewmodel.GuessGameViewModel
import com.example.interntasks3.viewmodel.SharedViewModel

class GuessGameFragment : Fragment() {

    private lateinit var binding: FragmentGuessGameBinding
    private val viewModel: GuessGameViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGuessGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.randomCharLiveData.observe(viewLifecycleOwner, Observer { char ->
            binding.charTextView.text = char.toString()
        })

        viewModel.resultLiveData.observe(viewLifecycleOwner, Observer { result ->
            binding.resultTextView.text = result
        })

        for (i in 0..9) {
            val buttonId = resources.getIdentifier("button$i", "id", requireContext().packageName)
            val button = view.findViewById<Button>(buttonId)
            button?.setOnClickListener {
                viewModel.updateGuessedNumber(i)
                binding.resultTextView.text = i.toString()
            }
        }

        binding.buttonGuess.setOnClickListener {
            viewModel.checkGuess()
        }

        binding.charTextView.setOnClickListener {
            sharedViewModel.HiddenNumber(
                viewModel.randomNumberLiveData.value ?: return@setOnClickListener
            )
            val action = GuessGameFragmentDirections.actionGuessGameFragmentToDetailFragment()
            findNavController().navigate(action)
        }

        binding.buttonClear.setOnClickListener {
            viewModel.resetGame()
            binding.resultTextView.text = ""
        }
    }
}
