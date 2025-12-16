package com.marossolutions.navigation.navigator

import com.marossolutions.navigation.NavigationState
import com.marossolutions.navigation.screen.AppScreen
import javax.inject.Inject

class NavigatorImpl @Inject constructor() : Navigator {

    private var navigationState: NavigationState? = null

    override fun setNavigationState(state: NavigationState) {
        navigationState = state
    }

    override fun navigateTo(screen: AppScreen) {
        navigationState?.backStack?.add(screen)
    }

    override fun navigateUp() {
        navigationState?.backStack?.removeLastOrNull()
    }
}
