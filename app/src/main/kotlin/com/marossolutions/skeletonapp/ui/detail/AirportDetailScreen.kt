package com.marossolutions.skeletonapp.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.marossolutions.skeletonapp.repository.model.AirportDetail
import com.marossolutions.skeletonapp.ui.component.FullScreenLoading
import com.marossolutions.skeletonapp.ui.theme.SkeletonAppTheme
import com.marossolutions.skeletonapp.ui.theme.annotation.ThemePreviews
import com.marossolutions.skeletonapp.viewmodel.AirportDetailViewModel

@Composable
internal fun AirportDetailScreen(
    airportId: String,
    viewModel: AirportDetailViewModel = hiltViewModel()
) {

    LaunchedEffect(Unit) {
        viewModel.fetchAirport(airportId)
    }

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (val state = uiState) {
        is AirportDetailViewModel.AirportDetailUiState.Loading -> FullScreenLoading()
        is AirportDetailViewModel.AirportDetailUiState.Content -> AirportDetailScreenContent(
            airport = state.airportDetail
        )
    }
}

@Composable
private fun AirportDetailScreenContent(airport: AirportDetail) {
    Column {
        Text(text = "DETAIL")

        Text(text = airport.name + " " + airport.city + " " + airport.timeZone)
    }
}

@ThemePreviews
@Composable
private fun AirportDetailScreenContentPreview() {
    SkeletonAppTheme {
        AirportDetailScreenContent(
            airport = AirportDetail(
                id = "1",
                name = "TEST 1",
                city = "Test city",
                timeZone = "Test time zone"
            )
        )
    }
}