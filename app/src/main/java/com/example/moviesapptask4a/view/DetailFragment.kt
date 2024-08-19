package com.example.moviesapptask4a.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapptask4a.R
import com.example.moviesapptask4a.adapter.ActorsAdapter
import com.example.moviesapptask4a.databinding.FragmentDetailBinding
import com.example.moviesapptask4a.util.loadCircleImage
import com.example.moviesapptask4a.viewmodel.DetailViewModel

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val viewModel by viewModels<DetailViewModel>()
    private val args by navArgs<DetailFragmentArgs>()
    private lateinit var actorsAdapter: ActorsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        viewModel.getMovieDetail(movieId = args.movieId)
        observe()

        return binding.root
    }

    private fun observe() {
        with(binding) {
            viewModel.errorMessage.observe(viewLifecycleOwner) { error ->
                errorDetailTextView.text = error
                errorDetailTextView.isVisible = true
            }

            viewModel.isLoading.observe(viewLifecycleOwner) { loading ->
                progressBarDetail.isVisible = loading
            }

            viewModel.movieResponse.observe(viewLifecycleOwner) { movie ->
                movie.backdropPath?.let { detailImage.loadCircleImage(it) }
                summaryTextView.text = movie.overview
                filmTitleText.text = movie.title
                detailVoteTextView.text = movie.voteAverage.toString()

            }

            viewModel.actorsList.observe(viewLifecycleOwner) { actorList ->
                if (actorList.isNullOrEmpty()) {
                    errorDetailTextView.text = getString(R.string.nullMessage)
                    errorDetailTextView.isVisible = true
                } else {
                    actorsAdapter = ActorsAdapter(actorList)
                }
                imagesRecycler.adapter = actorsAdapter
                imagesRecycler.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            }
        }
    }
}