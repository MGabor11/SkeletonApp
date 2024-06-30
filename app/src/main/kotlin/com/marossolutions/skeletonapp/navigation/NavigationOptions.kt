package com.marossolutions.skeletonapp.navigation

import com.marossolutions.skeletonapp.navigation.screens.AppScreen

data class NavigationOptions(
    val popUpToScreen: AppScreen,
    val popUpToInclusive: Boolean
)
