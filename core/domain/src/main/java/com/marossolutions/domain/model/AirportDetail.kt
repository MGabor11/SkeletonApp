package com.marossolutions.domain.model

data class AirportDetail(
    override val id: String,
    val iataCode: String?,
    override val name: String,
    val latitude: Double,
    val longitude: Double,
    val city: String? = null, // TODO update the application with City API call
) : BaseAirportModel
