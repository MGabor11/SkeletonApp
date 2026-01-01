package com.marossolutions.domain.model

data class Airport(
    override val id: String,
    override val name: String,
) : BaseAirportModel
