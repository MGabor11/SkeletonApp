package com.marossolutions.network.datasource

import com.marossolutions.network.model.AirportApiModel
import com.marossolutions.network.model.AirportDetailApiModel

interface AirportRemoteDataSource {

    suspend fun getAirportsByCountry(countryCode: String): List<AirportApiModel>

    suspend fun getAirportByICAO(airportIcao: String): AirportDetailApiModel?
}
