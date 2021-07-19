package com.cblanco.moviesapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.cblanco.moviesapp.R
import com.cblanco.moviesapp.data.model.Movie
import com.cblanco.moviesapp.ui.adapter.viewholders.MoviesViewHolder

class MoviesAdapter(
    var adapterInterface: OnMovieAdapterInterface
) :  ListAdapter<Movie, MoviesViewHolder>(MovieListDiffCalback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_adapter_movies, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
        holder.cardView.setOnClickListener {
            movie.id?.let { id->
                adapterInterface.OnMovieSelected(id)
            }
        }
    }

}

    class MovieListDiffCalback : DiffUtil.ItemCallback<Movie>(){
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
}

interface OnMovieAdapterInterface {
    fun OnMovieSelected(movieId: Int)
}