package com.marossolutions.network.datasource

import com.marossolutions.network.AirportsRetrofitApi
import com.marossolutions.network.model.AirportApiModel
import com.marossolutions.network.model.AirportDetailApiModel
import javax.inject.Inject

class AirportRemoteDataSourceImpl @Inject constructor(
    private val airportsApi: AirportsRetrofitApi
) : AirportRemoteDataSource {

    override suspend fun getAirportsByCountry(countryCode: String): List<AirportApiModel> {
        return airportsApi.getAirportsByCountry(countryCode).response
    }

    override suspend fun getAirportByICAO(airportIcao: String): AirportDetailApiModel? {
        return airportsApi.getAirportsByICAO(airportIcao).response.firstOrNull()
    }
}
