package com.example.moviesapptask4a.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapptask4a.databinding.ActorsRecyclerviewBinding
import com.example.moviesapptask4a.model.Cast
import com.example.moviesapptask4a.util.loadCircleImage

class ActorsAdapter(private val actorsList: List<Cast?>) :
    RecyclerView.Adapter<ActorsAdapter.ViewHolder>() {
    class ViewHolder(val binding: ActorsRecyclerviewBinding) : RecyclerView.ViewHolder(binding.root)

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
        val actor = actorsList[position]

        actor?.let {
            holder.binding.actorsNameText.text = it.name
            it.profilePath?.let { path ->
                holder.binding.imageActors.loadCircleImage(path)
            }
        }
    }
}