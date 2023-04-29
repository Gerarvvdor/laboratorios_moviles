package movieapp.repository

import com.orellana.models.Movie

class MovieRepository(private var movies: MutableList<Movie>) {

    fun getMovies() = movies
}