package com.marossolutions.navigation.navigator

import com.marossolutions.navigation.NavigationState
import com.marossolutions.navigation.screen.AppScreen

interface Navigator {

    fun setNavigationState(state: NavigationState)

    fun navigateTo(screen: AppScreen)

    fun navigateUp()
}
