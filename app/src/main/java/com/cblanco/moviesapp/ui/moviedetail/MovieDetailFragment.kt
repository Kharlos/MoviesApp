package com.cblanco.moviesapp.ui.moviedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.cblanco.moviesapp.databinding.MovieDetailFragmentBinding
import com.cblanco.moviesapp.di.builder.framework.viewmodel.ViewModelFactory
import com.cblanco.moviesapp.util.extensions.loadImgFromUrl
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MovieDetailFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by viewModels<MovieDetailViewModel> { viewModelFactory }

    private var binding: MovieDetailFragmentBinding? = null

    private val args:MovieDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MovieDetailFragmentBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.loadMovieDetail(args.movieId)
    }

    private fun setupObservers() {
        viewModel.movieDetail.observe(viewLifecycleOwner, {
            binding?.originalTitle?.text = it.originalTitle
            binding?.movieImage?.loadImgFromUrl("https://image.tmdb.org/t/p/w500${it.posterPath}")
            binding?.homepage?.text = it.homepage
            binding?.overview?.text = it.overview
            binding?.rate?.rating = it.voteAverage?.toFloat() ?: 0f
        })
    }

}