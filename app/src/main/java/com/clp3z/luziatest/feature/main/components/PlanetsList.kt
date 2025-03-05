package com.clp3z.luziatest.feature.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.clp3z.luziatest.entity.Planet
import com.clp3z.luziatest.feature.common.PlanetCard
import com.clp3z.luziatest.feature.common.previewPlanets
import com.clp3z.luziatest.framework.theme.AppTheme
import com.clp3z.luziatest.framework.theme.Spacing

@Composable
fun PlanetsList(
    modifier: Modifier = Modifier,
    planets: List<Planet>,
    onPlanetClick: (Planet) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        itemsIndexed(
            items = planets,
            key = { _, planet -> planet.url }
        ) { index, planet ->
            if (index == 0) Spacer(modifier = Modifier.padding(Spacing.spacing_8))
            PlanetCard(
                modifier = Modifier.padding(horizontal = Spacing.spacing_16),
                planet = planet,
                onPlanetClick = onPlanetClick
            )
            Spacer(modifier = Modifier.padding(Spacing.spacing_8))
        }
    }
}

@Preview
@Composable
private fun PlanetsListPreview() {
    AppTheme {
        PlanetsList(
            planets = previewPlanets,
            onPlanetClick = {}
        )
    }
}
