package com.marossolutions.skeletonapp.viewmodel

import androidx.lifecycle.ViewModel
import com.marossolutions.skeletonapp.navigation.NavigationOptions
import com.marossolutions.skeletonapp.navigation.SimpleNavigator
import com.marossolutions.skeletonapp.navigation.screens.ScreenHome
import com.marossolutions.skeletonapp.navigation.screens.ScreenWelcome
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class WelcomeViewModel @Inject constructor(
    private val simpleNavigator: SimpleNavigator
) : ViewModel() {

    internal fun navigateToHome() {
        simpleNavigator.navigateTo(
            screen = ScreenHome,
            navigationOptions = NavigationOptions(
                popUpToScreen = ScreenWelcome,
                popUpToInclusive = true
            )
        )
    }
}
