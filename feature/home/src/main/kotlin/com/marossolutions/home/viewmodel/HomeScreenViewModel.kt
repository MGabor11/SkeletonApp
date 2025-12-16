package com.marossolutions.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marossolutions.common.DataResult
import com.marossolutions.domain.model.Airport
import com.marossolutions.domain.repository.AirportRepository
import com.marossolutions.navigation.navigator.Navigator
import com.marossolutions.navigation.screen.ScreenAirportDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val airportRepository: AirportRepository,
    private val navigator: Navigator
) : ViewModel() {

    val uiState: StateFlow<HomeUiState> =
        airportRepository.airports.map { airportsResult ->
            val successfulResult = airportsResult as? DataResult.Success<List<Airport>>
            successfulResult?.data?.let { airports ->
                if (airports.isNotEmpty()) {
                    HomeUiState.Content(airports)
                } else {
                    HomeUiState.Loading
                }
            } ?: HomeUiState.Loading
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = HomeUiState.Loading
        )

    init {
        viewModelScope.launch {
            airportRepository.fetchAirports("HU")
        }
    }

    fun navigateToDetail(id: String) {
        navigator.navigateTo(ScreenAirportDetail(aiportIcao = id))
    }
}

internal sealed interface HomeUiState {
    data object Loading : HomeUiState
    data class Content(val airports: List<Airport>) : HomeUiState
}
