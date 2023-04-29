package com.orellana.labo05

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.orellana.models.moviesDatabase
import movieapp.repository.MovieRepository

class MovieViewModel(private var repository: MovieRepository):ViewModel(){


    fun getMovies() = repository.getMovies()

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val repository = MovieRepository(moviesDatabase)
                MovieViewModel(repository)
            }
        }
    }
}
