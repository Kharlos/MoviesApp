package com.cblanco.moviesapp.ui.movieslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cblanco.moviesapp.databinding.MoviesListFragmentBinding
import com.cblanco.moviesapp.di.builder.framework.viewmodel.ViewModelFactory
import com.cblanco.moviesapp.ui.adapter.MoviesAdapter
import com.cblanco.moviesapp.ui.adapter.OnMovieAdapterInterface
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MoviesListFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: MoviesListViewModel by viewModels<MoviesListViewModel> { viewModelFactory }

    private var binding: MoviesListFragmentBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MoviesListFragmentBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        viewModel.getPopularMovies()
    }

    private fun setupObservers() {

        viewModel.movies.observe(viewLifecycleOwner, {
            binding?.rvMovies?.apply {
                layoutManager =
                    LinearLayoutManager(requireActivity())
                adapter = MoviesAdapter(it, object : OnMovieAdapterInterface{
                    override fun OnMovieSelected(movieId: Int) {
                        findNavController().navigate(
                            MoviesListFragmentDirections.actionMoviesListFragmentToMovieDetailFragment(movieId)
                        )
                    }

                })
            }

        })
    }


}