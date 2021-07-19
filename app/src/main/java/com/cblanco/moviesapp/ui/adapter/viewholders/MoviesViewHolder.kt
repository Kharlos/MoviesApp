package com.cblanco.moviesapp.ui.adapter.viewholders

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.cblanco.moviesapp.R
import com.cblanco.moviesapp.data.model.Movie
import com.cblanco.moviesapp.util.extensions.loadImgFromUrl

class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(movie: Movie) {
        movieTitle.text = movie.title ?: ""
        moviePoster.loadImgFromUrl("https://image.tmdb.org/t/p/w500" + movie.imgUrl ?: "")

    }

    var cardView = itemView.findViewById<CardView>(R.id.cardView)
    var moviePoster = itemView.findViewById<AppCompatImageView>(R.id.moviePoster)
    var movieTitle = itemView.findViewById<TextView>(R.id.movieTitle)
}
