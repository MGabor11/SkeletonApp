package com.marossolutions.skeletonapp.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AirportApiModel(
    override val icao: String,
    override val name: String
) : BaseAirportApiModel
