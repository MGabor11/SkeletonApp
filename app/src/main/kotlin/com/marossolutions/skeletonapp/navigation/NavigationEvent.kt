package com.marossolutions.skeletonapp.navigation

import com.marossolutions.skeletonapp.navigation.screens.AppScreen

sealed interface NavigationEvent {

    data object NavigateUp : NavigationEvent

    data class ForwardNavigation(
        val screen: AppScreen,
        val navigationOptions: NavigationOptions? = null
    ) : NavigationEvent
}