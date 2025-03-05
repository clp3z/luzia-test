package com.clp3z.luziatest.feature.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.clp3z.luziatest.R
import com.clp3z.luziatest.entity.Error
import com.clp3z.luziatest.entity.Planet
import com.clp3z.luziatest.feature.common.ErrorMessage
import com.clp3z.luziatest.feature.main.components.PlanetsList
import com.clp3z.luziatest.feature.common.previewPlanets
import com.clp3z.luziatest.framework.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainLayout(
     error: Error?,
     isLoading: Boolean,
     planets: List<Planet>,
     onPlanetClick: (Planet) -> Unit
) {
    Scaffold(
        containerColor = Color.LightGray,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.app_name),
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.DarkGray)
            )
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            when {
                error != null -> ErrorMessage(error = error)
                isLoading -> CircularProgressIndicator(color = Color.Yellow)
                else -> PlanetsList(
                    planets = planets,
                    onPlanetClick = onPlanetClick
                )
            }
        }
    }
}

@Preview
@Composable
private fun MainLayoutPreview() {
    AppTheme {
        MainLayout(
            error = null,
            isLoading = false,
            planets = previewPlanets,
            onPlanetClick = {}
        )
    }
}
