package com.marossolutions.skeletonapp.navigation.screens

import kotlinx.serialization.Serializable

@Serializable
data class ScreenAirportDetail(
   val airportId: String
) : AppScreen
