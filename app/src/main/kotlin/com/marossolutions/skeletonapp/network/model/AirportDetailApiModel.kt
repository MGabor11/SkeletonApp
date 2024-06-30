package com.marossolutions.skeletonapp.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AirportDetailApiModel(
    override val icao: String,
    override val name: String,
    val city: String,
    @field:Json(name = "timezone") val timeZone: String
) : BaseAirportApiModel
