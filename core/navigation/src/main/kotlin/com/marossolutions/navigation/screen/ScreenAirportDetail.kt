package com.marossolutions.navigation.screen

import com.marossolutions.navigation.R
import kotlinx.serialization.Serializable

@Serializable
data class ScreenAirportDetail(val aiportIcao: String) : AppScreen {
    override val titleId = R.string.airport_detail_title
}