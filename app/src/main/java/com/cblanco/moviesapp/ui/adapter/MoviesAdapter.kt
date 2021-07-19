package com.cblanco.moviesapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cblanco.moviesapp.R
import com.cblanco.moviesapp.data.model.Movie
import com.cblanco.moviesapp.ui.adapter.viewholders.MoviesViewHolder

class MoviesAdapter(
    var movies: List<Movie>,
    var adapterInterface: OnMovieAdapterInterface
) : RecyclerView.Adapter<MoviesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_adapter_movies, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(movies[position])
        holder.cardView.setOnClickListener {
            movies[position].id?.let { id->
                adapterInterface.OnMovieSelected(id)
            }
        }
    }

    override fun getItemCount(): Int = movies.size

}

interface OnMovieAdapterInterface {
    fun OnMovieSelected(movieId: Int)
}