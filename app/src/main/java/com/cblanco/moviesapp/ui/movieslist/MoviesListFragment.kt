package com.cblanco.moviesapp.ui.movieslist

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cblanco.moviesapp.R
import com.cblanco.moviesapp.data.model.Movie
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
    private lateinit var movieAdapter: MoviesAdapter


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
        setupUI()
        viewModel.getPopularMovies()
    }

    private fun setupUI() {

        binding?.etSearch?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (!p0?.toString().isNullOrBlank())
                    viewModel.filterByName(p0.toString())
            }
        })
    }

    private fun setupObservers() {


        viewModel.progressBar.observe(viewLifecycleOwner, {
            binding?.loader?.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.movies.observe(viewLifecycleOwner, {
            if (it != null) showMovieList(it) else showAnError()
        })

        viewModel.filters.observe(viewLifecycleOwner, {
            if (it != null) showMovieList(it) else showAnError()
        })
    }


    private fun showMovieList(movieList: List<Movie>) {

        movieAdapter = MoviesAdapter(object : OnMovieAdapterInterface{
            override fun OnMovieSelected(movieId: Int) {
                findNavController().navigate(
                    MoviesListFragmentDirections.actionMoviesListFragmentToMovieDetailFragment(movieId)
                )
            }
        })

        binding?.rvMovies?.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            adapter = movieAdapter
        }
        when(movieList.size){
            0->{
                emptyState()
            }
            else->{
                binding?.tvError?.visibility = View.GONE
                binding?.rvMovies?.visibility = View.VISIBLE
                movieAdapter.submitList(movieList)
            }
        }
    }

    private fun showAnError() {
        binding?.loader?.visibility = View.GONE
        binding?.tvError?.visibility = View.VISIBLE
        binding?.rvMovies?.visibility = View.GONE
    }

    private fun emptyState() {
        binding?.tvError?.visibility = View.VISIBLE
        binding?.rvMovies?.visibility = View.GONE

    }

}