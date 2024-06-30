package com.marossolutions.skeletonapp.network

import com.marossolutions.skeletonapp.network.model.AirportApiModel
import com.marossolutions.skeletonapp.network.model.AirportDetailApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AirportApiService {

    @GET("airports")
    suspend fun getAirportsByCountry(@Query(COUNTRY_PARAMETER) countryCode: String): Response<List<AirportApiModel>>

    @GET("airports")
    suspend fun getAirportsByICAO(@Query(ICAO_PARAMETER) icao: String): Response<List<AirportDetailApiModel>>

    companion object {
        const val COUNTRY_PARAMETER = "country"
        const val ICAO_PARAMETER = "icao"
    }
}
