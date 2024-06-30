package com.marossolutions.skeletonapp.repository

import com.marossolutions.skeletonapp.network.AirportApiService
import com.marossolutions.skeletonapp.repository.model.Airport
import com.marossolutions.skeletonapp.repository.model.AirportDetail
import com.marossolutions.skeletonapp.service.DispatcherProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AirportRepositoryImpl @Inject constructor(
    private val airportApiService: AirportApiService,
    private val dispatcherProvider: DispatcherProvider
) : AirportRepository {

    private val _airports = MutableStateFlow<List<Airport>?>(null)

    private val _airportDetail = MutableStateFlow<AirportDetail?>(null)

    override val airports: StateFlow<List<Airport>?> = _airports.asStateFlow()

    override val airportDetail: StateFlow<AirportDetail?> = _airportDetail.asStateFlow()

    override suspend fun fetchAirports(country: String) {
        withContext(dispatcherProvider.default) {
            _airports.value = null
            _airports.value = airportApiService.getAirportsByCountry(country).body()?.map {
                Airport(id = it.icao, name = it.name)
            }
        }
    }

    override suspend fun fetchAirport(icao: String) {
        withContext(dispatcherProvider.default) {
            _airportDetail.value = null
            _airportDetail.value =
                airportApiService.getAirportsByICAO(icao).body()
                    ?.firstOrNull()
                    ?.let { airportDetail ->
                        AirportDetail(
                            id = airportDetail.icao,
                            name = airportDetail.name,
                            city = airportDetail.city,
                            timeZone = airportDetail.timeZone
                        )
                    }
        }
    }
}