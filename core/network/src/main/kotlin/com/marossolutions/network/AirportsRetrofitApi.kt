package com.marossolutions.network

import com.marossolutions.network.model.AirportApiModel
import com.marossolutions.network.model.AirportDetailApiModel
import kotlinx.serialization.Serializable
import retrofit2.http.GET
import retrofit2.http.Query

private const val COUNTRY_CODE_PARAMETER = "country_code"
private const val ICAO_CODE_PARAMETER = "icao_code"

interface AirportsRetrofitApi {

    @GET("airports")
    suspend fun getAirportsByCountry(@Query(COUNTRY_CODE_PARAMETER) countryCode: String): NetworkResponse<List<AirportApiModel>>

    @GET("airports")
    suspend fun getAirportsByICAO(@Query(ICAO_CODE_PARAMETER) airportIcao: String): NetworkResponse<List<AirportDetailApiModel>>
}

@Serializable
data class NetworkResponse<T>(
    val response: T,
)
