package com.example.moviesapptask4a.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapptask4a.R
import com.example.moviesapptask4a.adapter.MovieAdapter
import com.example.moviesapptask4a.adapter.MovieClickListener
import com.example.moviesapptask4a.databinding.FragmentListBinding
import com.example.moviesapptask4a.viewmodel.ListViewModel

class ListFragment : Fragment() {

    lateinit var binding: FragmentListBinding
    private val viewModel by viewModels<ListViewModel>()
    private lateinit var bestOfMoviesAdapter: MovieAdapter
    private lateinit var topRatedMoviesAdapter: MovieAdapter
    private lateinit var upcomingMoviesAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
        viewModel.getMovieList()
    }

    private fun observe() {
        with(binding) {

            viewModel.errorMessage.observe(viewLifecycleOwner) { error ->
                textViewError.text = error
                textViewError.isVisible = true
            }

            viewModel.isLoading.observe(viewLifecycleOwner) { loading ->
                progressBar.isVisible = loading
                progressBar2.isVisible = loading
                progressBar3.isVisible = loading
            }

            viewModel.popularMoviesList.observe(viewLifecycleOwner) { popularList ->
                if (popularList.isNullOrEmpty()) {
                    textViewError.text = R.string.nullMessage.toString()
                    textViewError.isVisible = true
                } else {
                    bestOfMoviesAdapter = MovieAdapter(popularList, object : MovieClickListener {
                        override fun onMovieClicted(movieId: Int) {
                            movieId?.let {
                                val action =
                                    ListFragmentDirections.actionListFragmentToDetailFragment(it)
                                findNavController().navigate(action)
                            }
                        }

                    })
                    bestOfMoviesView.adapter = bestOfMoviesAdapter
                }
                bestOfMoviesView.adapter = bestOfMoviesAdapter
                bestOfMoviesView.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            }

            viewModel.topRatedMoviesList.observe(viewLifecycleOwner) { topRatedList ->
                if (topRatedList.isNullOrEmpty()) {
                    textViewError.text = R.string.nullMessage.toString()
                    textViewError.isVisible = true
                } else {
                    topRatedMoviesAdapter = MovieAdapter(topRatedList, object : MovieClickListener {
                        override fun onMovieClicted(movieId: Int) {
                            movieId?.let {
                                val action =
                                    ListFragmentDirections.actionListFragmentToDetailFragment(it)
                                findNavController().navigate(action)
                            }
                        }
                    })
                    topRatedMoviesView.adapter = topRatedMoviesAdapter
                }
                topRatedMoviesView.adapter = topRatedMoviesAdapter
                topRatedMoviesView.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            }

            viewModel.upcomingMoviesList.observe(viewLifecycleOwner) { upcomingList ->
                if (upcomingList.isNullOrEmpty()) {
                    textViewError.text = R.string.nullMessage.toString()
                    textViewError.isVisible = true
                } else {
                    upcomingMoviesAdapter = MovieAdapter(upcomingList, object : MovieClickListener {
                        override fun onMovieClicted(movieId: Int) {
                            movieId?.let {
                                val action =
                                    ListFragmentDirections.actionListFragmentToDetailFragment(it)
                                findNavController().navigate(action)
                            }
                        }
                    })
                    upcomigMoviesView.adapter = upcomingMoviesAdapter
                }
                upcomigMoviesView.adapter = upcomingMoviesAdapter
                upcomigMoviesView.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            }
        }
    }
}