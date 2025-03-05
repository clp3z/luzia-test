package com.clp3z.luziatest.feature.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DetailScreen(
    viewModel: DetailViewModel = hiltViewModel(),
    url: String,
    onUpClick: () -> Unit
) {

    val viewState by viewModel.viewState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.initialize(url)
    }

    DetailLayout(
        error = viewState.error,
        isLoading = viewState.isLoading,
        planet = viewState.planet,
        onUpClick = onUpClick
    )
}
