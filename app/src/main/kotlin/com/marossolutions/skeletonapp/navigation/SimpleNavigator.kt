package com.marossolutions.skeletonapp.navigation

import com.marossolutions.skeletonapp.navigation.screens.AppScreen
import kotlinx.coroutines.flow.Flow

interface SimpleNavigator {

    val navigationEvents: Flow<NavigationEvent>

    fun navigateTo(screen: AppScreen, navigationOptions: NavigationOptions? = null)

    fun navigateUp()
}