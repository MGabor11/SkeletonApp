package com.marossolutions.skeletonapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marossolutions.skeletonapp.navigation.NavigationOptions
import com.marossolutions.skeletonapp.navigation.SimpleNavigator
import com.marossolutions.skeletonapp.navigation.screens.ScreenAirportDetail
import com.marossolutions.skeletonapp.navigation.screens.ScreenHome
import com.marossolutions.skeletonapp.navigation.screens.ScreenSplash
import com.marossolutions.skeletonapp.repository.AirportRepository
import com.marossolutions.skeletonapp.repository.model.Airport
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val airportRepository: AirportRepository,
    private val simpleNavigator: SimpleNavigator
) : ViewModel() {

    internal val uiState: StateFlow<HomeUiState> = airportRepository.airports.map { airports ->
        if (airports.isNullOrEmpty()) {
            HomeUiState.Loading
        } else {
            HomeUiState.Content(airports)
        }
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

    internal fun navigateToDetail(id: String) {
        simpleNavigator.navigateTo(ScreenAirportDetail(airportId = id))
    }

    internal sealed interface HomeUiState {
        data object Loading : HomeUiState
        data class Content(val airports: List<Airport>) : HomeUiState
    }
}
