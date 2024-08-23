package com.example.moviesapptask4a.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapptask4a.R
import com.example.moviesapptask4a.databinding.MovieRecyclerviewBinding
import com.example.moviesapptask4a.model.FavoriteMovie
import com.example.moviesapptask4a.util.Constants


class FavoriteMovieAdapter(
    private var favoriteMovieList: List<FavoriteMovie>,
    private val isFavorite: (FavoriteMovie) -> Boolean,
    private val onFavoriteClick: (FavoriteMovie) -> Unit,
    private val onMovieClick: (FavoriteMovie) -> Unit,
) : RecyclerView.Adapter<FavoriteMovieAdapter.FavoriteMovieViewHolder>() {

    inner class FavoriteMovieViewHolder(private val binding: MovieRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(favoriteMovie: FavoriteMovie) {
            binding.titleTxt.text = favoriteMovie.title
            Glide.with(binding.root)
                .load(Constants.BASE_IMAGE_URL + favoriteMovie.posterUrl)
                .into(binding.imagePoster)

            binding.root.setOnClickListener {
                onMovieClick(favoriteMovie)
            }

            binding.imageFavorite.setOnClickListener {
                onFavoriteClick(favoriteMovie)
                toggleFavoriteIcon(favoriteMovie)
            }

            toggleFavoriteIcon(favoriteMovie)
        }

        private fun toggleFavoriteIcon(movie: FavoriteMovie) {
            val icon = if (isFavorite(movie)) {
                R.drawable.baseline_favorite_24
            } else {
                R.drawable.baseline_favorite_border
            }
            binding.imageFavorite.setImageResource(icon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMovieViewHolder {
        return FavoriteMovieViewHolder(
            MovieRecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FavoriteMovieViewHolder, position: Int) {
        holder.bind(favoriteMovieList[position])
    }

    override fun getItemCount(): Int {
        return favoriteMovieList.size
    }

    fun updateFavoriteList(newFavoriteList: List<FavoriteMovie>) {
        favoriteMovieList = newFavoriteList
        notifyDataSetChanged()
    }
}