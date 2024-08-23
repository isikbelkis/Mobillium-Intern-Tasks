package com.example.moviesapptask4a.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviesapptask4a.adapter.FavoriteMovieAdapter
import com.example.moviesapptask4a.databinding.FragmentFavoriteBinding
import com.example.moviesapptask4a.viewmodel.FavoriteMovieViewModel

class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding
    private val favoriteViewModel by viewModels<FavoriteMovieViewModel>()
    private lateinit var favoriteMoviesAdapter: FavoriteMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoriteMoviesAdapter = FavoriteMovieAdapter(
            favoriteMovieList = emptyList(),
            isFavorite = { movie -> favoriteViewModel.isFavorite(movie) },
            onFavoriteClick = { movie ->
                favoriteViewModel.toggleFavorite(movie)
                favoriteMoviesAdapter.updateFavoriteList(favoriteViewModel.allFavoriteMovies.value ?: emptyList())
            },
            onMovieClick = { movie ->
                val action =
                    FavoriteFragmentDirections.actionFavoriteFragmentToDetailFragment(movie.id!!)
                findNavController().navigate(action)
            }
        )

        binding.favoriteRecyclerView.layoutManager = GridLayoutManager(context, 2)
        binding.favoriteRecyclerView.adapter = favoriteMoviesAdapter

        favoriteViewModel.allFavoriteMovies.observe(viewLifecycleOwner) { listFavoriteMovie ->
            favoriteMoviesAdapter.updateFavoriteList(listFavoriteMovie)
        }
    }
}
