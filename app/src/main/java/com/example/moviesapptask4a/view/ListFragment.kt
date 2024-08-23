package com.example.moviesapptask4a.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapptask4a.R
import com.example.moviesapptask4a.adapter.MovieAdapter
import com.example.moviesapptask4a.databinding.FragmentListBinding
import com.example.moviesapptask4a.model.MoviesItem
import com.example.moviesapptask4a.viewmodel.ListViewModel

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val viewModel by viewModels<ListViewModel>()
    private lateinit var bestOfMoviesAdapter: MovieAdapter
    private lateinit var topRatedMoviesAdapter: MovieAdapter
    private lateinit var upcomingMoviesAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
        viewModel.getMovieList()
        binding.favoriteLinear.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToFavoriteFragment()
            findNavController().navigate(action)
        }
    }

    private fun setupList(
        movieList: List<MoviesItem?>?,
        adapterSetter: (MovieAdapter) -> Unit,
        recyclerView: RecyclerView,
        textViewError: TextView
    ) {
        if (movieList.isNullOrEmpty()) {
            textViewError.text = getString(R.string.errorMessage)
            textViewError.isVisible = true
        } else {
            textViewError.isVisible = false
            val movieAdapter = MovieAdapter(
                movieList,
                onFavoriteClick = { movie ->
                    viewModel.toggleFavorite(movie)
                },
                onMovieClick = { movie ->
                    val action =
                        ListFragmentDirections.actionListFragmentToDetailFragment(movieId = movie.id!!)
                    findNavController().navigate(action)
                },
                isFavorite = { movie ->
                    viewModel.isFavorite(movie.id!!).value ?: false
                }
            )
            adapterSetter(movieAdapter)
            recyclerView.adapter = movieAdapter
            recyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }


    private fun observe() {
        with(binding) {
            viewModel.errorMessage.observe(viewLifecycleOwner) { error ->
                textViewError.text = error
                textViewError.isVisible = true
            }

            viewModel.popularMoviesList.observe(viewLifecycleOwner) { popularList ->
                setupList(
                    popularList,
                    { bestOfMoviesAdapter = it },
                    bestOfMoviesView,
                    textViewError
                )
            }

            viewModel.upcomingMoviesList.observe(viewLifecycleOwner) { upcomingList ->
                setupList(
                    upcomingList,
                    { upcomingMoviesAdapter = it },
                    upcomigMoviesView,
                    textViewError
                )
            }

            viewModel.topRatedMoviesList.observe(viewLifecycleOwner) { topRatedList ->
                setupList(
                    topRatedList,
                    { topRatedMoviesAdapter = it },
                    topRatedMoviesView,
                    textViewError
                )
            }
        }
    }
}
