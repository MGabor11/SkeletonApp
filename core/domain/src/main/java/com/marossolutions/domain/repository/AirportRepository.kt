package com.marossolutions.domain.repository

import com.marossolutions.common.DataResult
import com.marossolutions.domain.model.Airport
import com.marossolutions.domain.model.AirportDetail
import kotlinx.coroutines.flow.StateFlow

interface AirportRepository {

    val airports: StateFlow<DataResult<List<Airport>>?>

    val airportDetail: StateFlow<DataResult<AirportDetail>?>

    suspend fun fetchAirports(country: String)

    suspend fun fetchAirport(airportIcao: String)

    fun clearAirportDetail()
}
