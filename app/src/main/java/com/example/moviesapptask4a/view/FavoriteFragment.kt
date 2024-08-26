package com.example.moviesapptask4a.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviesapptask4a.adapter.MovieAdapter
import com.example.moviesapptask4a.databinding.FragmentFavoriteBinding
import com.example.moviesapptask4a.viewmodel.SharedMovieViewModel

class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding
    private val sharedMovieViewModel: SharedMovieViewModel by activityViewModels()
    private lateinit var favoriteMoviesAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoriteMoviesAdapter = MovieAdapter(
            movieList = emptyList(),
            isFavorite = { movie -> sharedMovieViewModel.isFavorite(movie) },
            onFavoriteClick = { movie ->
                sharedMovieViewModel.toggleFavorite(movie)
            },
            onMovieClick = { movie ->
                val action = FavoriteFragmentDirections.actionFavoriteFragmentToDetailFragment(movie.id!!)
                findNavController().navigate(action)
            }
        )

        binding.favoriteRecyclerView.layoutManager = GridLayoutManager(context, 2)
        binding.favoriteRecyclerView.adapter = favoriteMoviesAdapter

        sharedMovieViewModel.favoriteMoviesLiveData.observe(viewLifecycleOwner){favoriteMovies->
            favoriteMoviesAdapter.updateMovies(favoriteMovies.toList())
        }
    }
}
