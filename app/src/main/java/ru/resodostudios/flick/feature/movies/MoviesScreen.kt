package ru.resodostudios.flick.feature.movies

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.resodostudios.flick.core.designsystem.component.RetrySection
import ru.resodostudios.flick.feature.movies.components.MovieCard
import ru.resodostudios.flick.feature.movies.domain.util.MoviesEvent

@Composable
internal fun MoviesRoute(
    viewModel: MoviesViewModel = hiltViewModel()
) {
    val moviesState by viewModel.state.collectAsStateWithLifecycle()

    MoviesScreen(
        state = moviesState,
        onRetry = viewModel::getMovies,
        onEvent = viewModel::onEvent
    )
}

@Composable
internal fun MoviesScreen(
    state: MoviesUiState,
    onEvent: (MoviesEvent) -> Unit,
    onRetry: () -> Unit
) {
    AnimatedVisibility(
        visible = !state.isLoading,
        enter = fadeIn()
    ) {
        LazyVerticalStaggeredGrid(
            contentPadding = PaddingValues(16.dp),
            verticalItemSpacing = 8.dp,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            columns = StaggeredGridCells.Adaptive(150.dp)
        ) {
            items(state.movies) { movie ->
                MovieCard(
                    movie = movie,
                    onNavigate = { }
                )
            }
        }
    }

    if (state.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    }

    if (state.isError) RetrySection(onClick = onRetry)
}