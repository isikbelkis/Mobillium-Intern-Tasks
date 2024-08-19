package com.example.moviesapptask4a.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapptask4a.databinding.ActorsRecyclerviewBinding
import com.example.moviesapptask4a.model.Cast
import com.example.moviesapptask4a.util.loadImage

class ActorsAdapter(private val actorsList: List<Cast?>) :
    RecyclerView.Adapter<ActorsAdapter.ViewHolder>() {
    class ViewHolder(private val binding: ActorsRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(actor: Cast) {
            binding.actorsNameText.text = actor.name
            actor.profilePath?.let { path ->
                binding.imageActors.loadImage(path)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ActorsRecyclerviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return actorsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(actorsList[position]!!)
    }
}
