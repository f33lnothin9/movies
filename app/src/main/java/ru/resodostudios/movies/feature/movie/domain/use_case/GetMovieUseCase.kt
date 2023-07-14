package ru.resodostudios.movies.feature.movie.domain.use_case

import ru.resodostudios.movies.feature.movie.domain.repository.MovieRepository
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(
    private val repository: MovieRepository
) {

    suspend operator fun invoke(id: Int) = repository.getMovie(id)
}