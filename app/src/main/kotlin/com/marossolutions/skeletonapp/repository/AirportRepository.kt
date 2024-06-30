package com.marossolutions.skeletonapp.repository

import com.marossolutions.skeletonapp.repository.model.Airport
import com.marossolutions.skeletonapp.repository.model.AirportDetail
import kotlinx.coroutines.flow.StateFlow

interface AirportRepository {

    val airports: StateFlow<List<Airport>?>

    val airportDetail: StateFlow<AirportDetail?>

    suspend fun fetchAirports(country: String)

    suspend fun fetchAirport(icao: String)
}