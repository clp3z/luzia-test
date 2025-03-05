package com.clp3z.luziatest.feature.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.clp3z.luziatest.R
import com.clp3z.luziatest.entity.Planet
import com.clp3z.luziatest.feature.main.components.InformationRow
import com.clp3z.luziatest.framework.theme.FullScreenPreview
import com.clp3z.luziatest.framework.theme.Spacing

@Composable
fun PlanetCard(
    modifier: Modifier = Modifier,
    planet: Planet,
    isDetail: Boolean = false,
    onPlanetClick: (Planet) -> Unit
) {
    val cardModifier = modifier
        .fillMaxWidth()
        .then(if (!isDetail) Modifier.clickable { onPlanetClick(planet) } else Modifier)

    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        modifier = cardModifier
    ) {
        Column(
            modifier = Modifier.padding(Spacing.spacing_16),
            verticalArrangement = Arrangement.spacedBy(Spacing.spacing_8)
        ) {
            Text(
                text = planet.name.uppercase(),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            InformationRow(name = stringResource(R.string.climate), value = planet.climate)
            InformationRow(name = stringResource(R.string.population), value = planet.population)
            if (isDetail) {
                InformationRow(name = stringResource(R.string.diameter), value = planet.diameter)
                InformationRow(name = stringResource(R.string.gravity), value = planet.gravity)
                InformationRow(name = stringResource(R.string.terrain), value = planet.terrain)
            }
        }
    }
}

@Preview
@Composable
private fun PlanetCardPreview() {
    FullScreenPreview {
        PlanetCard(
            modifier = Modifier.padding(Spacing.spacing_16),
            planet = previewPlanet,
            isDetail = true,
            onPlanetClick = {}
        )
    }
}
