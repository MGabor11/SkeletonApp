package com.marossolutions.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marossolutions.common.DataResult
import com.marossolutions.domain.model.AirportDetail
import com.marossolutions.domain.repository.AirportRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel(assistedFactory = AirportDetailViewModel.Factory::class)
internal class AirportDetailViewModel @AssistedInject constructor(
    private val airportRepository: AirportRepository,
    @Assisted val airportIcao: String,
) : ViewModel() {

    val uiState: StateFlow<AirportDetailUiState> =
        airportRepository.airportDetail.map { airportResult ->
            val successfulResult = airportResult as? DataResult.Success<AirportDetail>
            successfulResult?.let {
                AirportDetailUiState.Content(it.data)
            } ?: AirportDetailUiState.Loading
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = AirportDetailUiState.Loading
        )

    init {
        fetchAirport(airportIcao)
    }

    private fun fetchAirport(airportId: String) = viewModelScope.launch {
        airportRepository.fetchAirport(airportId)
    }

    override fun onCleared() {
        airportRepository.clearAirportDetail()
        super.onCleared()
    }

    @AssistedFactory
    interface Factory {
        fun create(
            airportIcao: String,
        ): AirportDetailViewModel
    }
}

internal sealed interface AirportDetailUiState {
    data object Loading : AirportDetailUiState
    data class Content(val airportDetail: AirportDetail) : AirportDetailUiState
}