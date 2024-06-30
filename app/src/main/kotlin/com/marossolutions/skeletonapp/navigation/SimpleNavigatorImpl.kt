package com.marossolutions.skeletonapp.navigation

import com.marossolutions.skeletonapp.navigation.screens.AppScreen
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

class SimpleNavigatorImpl @Inject constructor() : SimpleNavigator {

    private val _navigationEvents = MutableSharedFlow<NavigationEvent>(extraBufferCapacity = 1)
    override val navigationEvents = _navigationEvents.asSharedFlow()

    override fun navigateTo(screen: AppScreen, navigationOptions: NavigationOptions?) {
        _navigationEvents.tryEmit(NavigationEvent.ForwardNavigation(screen, navigationOptions))
    }

    override fun navigateUp() {
        _navigationEvents.tryEmit(NavigationEvent.NavigateUp)
    }
}
