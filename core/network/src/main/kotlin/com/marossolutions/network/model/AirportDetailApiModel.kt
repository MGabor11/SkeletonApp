package com.marossolutions.network.model

import com.marossolutions.domain.model.AirportDetail
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AirportDetailApiModel(
    @SerialName("icao_code") override val icaoCode: String,
    @SerialName("iata_code") val iataCode: String?,
    override val name: String,
    @SerialName("lat") val latitude: Double,
    @SerialName("lng") val longitude: Double,
) : BaseAirportApiModel

fun AirportDetailApiModel.toDomain(): AirportDetail {
    return AirportDetail(
        id = icaoCode,
        iataCode = iataCode,
        name = name,
        latitude = latitude,
        longitude = longitude,
    )
}
