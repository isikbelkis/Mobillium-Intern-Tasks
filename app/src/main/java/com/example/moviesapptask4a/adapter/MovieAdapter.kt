package com.example.moviesapptask4a.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapptask4a.databinding.MovieRecyclerviewBinding
import com.example.moviesapptask4a.model.MoviesItem
import com.example.moviesapptask4a.util.loadCircleImage


interface MovieClickListener{
    fun onMovieClicted(movieId:Int)
}
class MovieAdapter(private var movieList: List<MoviesItem?> , private val movieClickListener: MovieClickListener) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    class ViewHolder(val binding: MovieRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            MovieRecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movieList[position]

        movie?.let {
            holder.binding.titleTxt.text = it.title
            holder.binding.root.setOnClickListener {
                movie?.id?.let { it1 -> movieClickListener.onMovieClicted(movieId = it1) }
            }
            it.posterPath?.let { path ->
                holder.binding.imagePoster.loadCircleImage(path)
            }
        }
    }
}