package com.marossolutions.home.navigation

import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.marossolutions.home.ui.AirportDetailScreen
import com.marossolutions.home.ui.HomeScreen
import com.marossolutions.home.viewmodel.AirportDetailViewModel
import com.marossolutions.home.viewmodel.AirportDetailViewModel.Factory
import com.marossolutions.navigation.screen.ScreenAirportDetail
import com.marossolutions.navigation.screen.ScreenHome

fun EntryProviderScope<NavKey>.homeEntry() {
    entry<ScreenHome> {
        HomeScreen()
    }
    entry<ScreenAirportDetail> { key ->
        val aiportIcao = key.aiportIcao
        AirportDetailScreen(
            hiltViewModel<AirportDetailViewModel, Factory>(
                key = aiportIcao,
            ) { factory ->
                factory.create(aiportIcao)
            },
        )
    }
}
