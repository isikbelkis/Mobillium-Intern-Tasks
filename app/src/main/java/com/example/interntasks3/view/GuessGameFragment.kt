package com.example.interntasks3.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
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

        buttonId()

        with(binding) {
            viewModel.randomCharLiveData.observe(viewLifecycleOwner) { char ->
                charTextView.text = char.toString()
            }

            viewModel.resultLiveData.observe(viewLifecycleOwner) { result ->
                resultTextView.text = result
            }

            buttonGuess.setOnClickListener {
                viewModel.checkGuess()
            }

            charTextView.setOnClickListener {
                sharedViewModel.hiddenNumbers(
                    viewModel.randomNumberLiveData.value ?: return@setOnClickListener
                )
                val action = GuessGameFragmentDirections.actionGuessGameFragmentToDetailFragment()
                findNavController().navigate(action)
            }

            buttonClear.setOnClickListener {
                viewModel.resetGame()
                binding.resultTextView.text = " "
            }
        }
    }

    private fun buttonId() = with(binding) {
        val numberButtons = arrayOf(
            button1,
            button2,
            button3,
            button4,
            button5,
            button6,
            button7,
            button8,
            button9,
            button0
        )
        for (numberButton in numberButtons) {
            numberButton.setOnClickListener {
                val buttonText = numberButton.text.toString()
                resultTextView.text = buttonText

                viewModel.updateGuessedNumber(buttonText)
            }
        }
    }
}
