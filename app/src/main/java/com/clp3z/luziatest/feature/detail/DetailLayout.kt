package com.clp3z.luziatest.feature.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.clp3z.luziatest.entity.Error
import com.clp3z.luziatest.entity.Planet
import com.clp3z.luziatest.feature.common.ErrorMessage
import com.clp3z.luziatest.feature.common.PlanetCard
import com.clp3z.luziatest.feature.common.previewPlanet
import com.clp3z.luziatest.framework.theme.AppTheme
import com.clp3z.luziatest.framework.theme.Spacing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailLayout(
    error: Error?,
    isLoading: Boolean,
    planet: Planet?,
    onUpClick: () -> Unit
) {
    Scaffold(
        containerColor = Color.LightGray,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = planet?.name ?: "",
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.DarkGray),
                navigationIcon = {
                    IconButton(onClick = { onUpClick() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            tint = Color.White,
                            contentDescription = "Navigate Back"
                        )
                    }
                }
            )
        }
    ) { padding ->
        val boxAlignment = when (error != null || isLoading) {
            true -> Alignment.Center
            false -> Alignment.TopCenter
        }
        Box(
            contentAlignment = boxAlignment,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(Spacing.spacing_16)
        ) {
            when {
                error != null -> ErrorMessage(error = error)
                isLoading -> CircularProgressIndicator(color = Color.Yellow)
                else -> {
                    planet?.let {
                        PlanetCard(
                            planet = it,
                            isDetail = true,
                            onPlanetClick = {}
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun DetailLayoutPreview() {
    AppTheme {
        DetailLayout(
            error = null,
            isLoading = false,
            planet = previewPlanet,
            onUpClick = {}
        )
    }
}