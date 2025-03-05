package com.clp3z.luziatest.feature.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.clp3z.luziatest.entity.Planet

@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel(),
    onPlanetClick: (Planet) -> Unit
) {
    val viewState by viewModel.viewState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.initialize()
    }

    MainLayout(
        error = viewState.error,
        isLoading = viewState.isLoading,
        planets = viewState.planets,
        onPlanetClick = onPlanetClick
    )
}
