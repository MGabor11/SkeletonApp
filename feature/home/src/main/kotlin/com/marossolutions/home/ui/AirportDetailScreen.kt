package com.marossolutions.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.marossolutions.domain.model.AirportDetail
import com.marossolutions.home.viewmodel.AirportDetailUiState
import com.marossolutions.home.viewmodel.AirportDetailViewModel
import com.marossolutions.ui.annotation.ThemePreviews
import com.marossolutions.ui.component.FullScreenLoading
import com.marossolutions.ui.theme.SkeletonAppTheme


@Composable
internal fun AirportDetailScreen(
    viewModel: AirportDetailViewModel
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (val state = uiState) {
        is AirportDetailUiState.Loading -> FullScreenLoading()
        is AirportDetailUiState.Content -> AirportDetailScreenContent(
            airport = state.airportDetail
        )
    }
}

@Composable
private fun AirportDetailScreenContent(airport: AirportDetail) {
    Column {
        Text(text = "DETAIL")
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Name: ${airport.name}")
        airport.iataCode?.let { Text(text = "IATA Code: $it") }
        airport.city?.let { Text(text = "City: $it") }
        Text(text = "Coordinates: ${airport.latitude}, ${airport.longitude}")
    }
}

@ThemePreviews
@Composable
private fun AirportDetailScreenContentPreview() {
    SkeletonAppTheme {
        AirportDetailScreenContent(
            airport = AirportDetail(
                id = "KJFK",
                iataCode = "JFK",
                name = "John F. Kennedy International Airport",
                latitude = 40.6413,
                longitude = -73.7781,
                city = "New York"
            )
        )
    }
}