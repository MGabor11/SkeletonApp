package com.marossolutions.skeletonapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marossolutions.skeletonapp.navigation.SimpleNavigator
import com.marossolutions.skeletonapp.navigation.screens.ScreenAirportDetail
import com.marossolutions.skeletonapp.repository.AirportRepository
import com.marossolutions.skeletonapp.repository.model.Airport
import com.marossolutions.skeletonapp.repository.model.AirportDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class AirportDetailViewModel @Inject constructor(
    private val airportRepository: AirportRepository
) : ViewModel() {

    internal val uiState: StateFlow<AirportDetailUiState> =
        airportRepository.airportDetail.map { airport ->
            if (airport == null) {
                AirportDetailUiState.Loading
            } else {
                AirportDetailUiState.Content(airport)
            }
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = AirportDetailUiState.Loading
        )

    internal fun fetchAirport(airportId: String) = viewModelScope.launch {
        airportRepository.fetchAirport(airportId)
    }

    internal sealed interface AirportDetailUiState {
        data object Loading : AirportDetailUiState
        data class Content(val airportDetail: AirportDetail) : AirportDetailUiState
    }
}