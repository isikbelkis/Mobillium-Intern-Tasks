package com.example.moviesapptask4a.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapptask4a.R
import com.example.moviesapptask4a.databinding.MovieRecyclerviewBinding
import com.example.moviesapptask4a.model.MoviesItem
import com.example.moviesapptask4a.util.loadCircleImage

class MovieAdapter(
    private var movieList: List<MoviesItem?>,
    private val onMovieClick: (MoviesItem) -> Unit,
    private val onFavoriteClick: (MoviesItem) -> Unit,
    private val isFavorite: (MoviesItem) -> Boolean
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: MovieRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: MoviesItem) {
            binding.titleTxt.text = movie.title
            movie.posterPath?.let { path ->
                binding.imagePoster.loadCircleImage(path)
            }

            binding.root.setOnClickListener {
                onMovieClick(movie)
            }

            binding.imageFavorite.setOnClickListener {
                onFavoriteClick(movie)
                toggleFavoriteIcon(movie, isFavorite)
            }

            toggleFavoriteIcon(movie, isFavorite)
        }

        private fun toggleFavoriteIcon(movie: MoviesItem, isFavorite: (MoviesItem) -> Boolean) {
            val icon = if (isFavorite(movie)) {
                R.drawable.baseline_favorite_24
            } else {
                R.drawable.baseline_favorite_border
            }
            binding.imageFavorite.setImageResource(icon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MovieRecyclerviewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        movieList[position]?.let { movie ->
            holder.bind(movie)
        }
    }

    fun updateMovies(newMovieList: List<MoviesItem?>) {
        movieList = newMovieList
    }
}
