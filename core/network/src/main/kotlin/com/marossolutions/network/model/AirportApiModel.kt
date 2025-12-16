package com.marossolutions.network.model

import com.marossolutions.domain.model.Airport
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AirportApiModel(
    @SerialName("icao_code") override val icaoCode: String,
    override val name: String
) : BaseAirportApiModel

fun AirportApiModel.toDomain(): Airport {
    return Airport(
        id = icaoCode,
        name = name
    )
}
