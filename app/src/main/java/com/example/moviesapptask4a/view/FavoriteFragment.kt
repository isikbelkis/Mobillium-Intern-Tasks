package com.example.moviesapptask4a.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapptask4a.adapter.MovieAdapter
import com.example.moviesapptask4a.databinding.FragmentFavoriteBinding
import com.example.moviesapptask4a.viewmodel.FavoriteViewModel
import com.example.moviesapptask4a.viewmodel.SharedMovieViewModel

class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding
    private val sharedViewModel by activityViewModels<SharedMovieViewModel>()
    private val favoriteViewModel by viewModels<FavoriteViewModel>()
    private lateinit var favoriteMoviesAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observe()
    }

    private fun setupRecyclerView() {
        favoriteMoviesAdapter = MovieAdapter(
            movieList = emptyList(),
            onMovieClick = { movie ->
                val action =
                    FavoriteFragmentDirections.actionFavoriteFragmentToDetailFragment(movieId = movie.id!!)
                findNavController().navigate(action)
            },
            onFavoriteClick = { movie ->
                favoriteViewModel.toggleFavorite(movie)
            },
            isFavorite = { movie ->
                sharedViewModel.isFavorite(movie)
            }
        )
        binding.favoriteRecyclerView.apply {
            adapter = favoriteMoviesAdapter
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun observe() {
        sharedViewModel.favoriteMovies.observe(viewLifecycleOwner) { favoriteMovies ->
            favoriteMoviesAdapter.updateMovies(favoriteMovies.toList())
        }
    }
}