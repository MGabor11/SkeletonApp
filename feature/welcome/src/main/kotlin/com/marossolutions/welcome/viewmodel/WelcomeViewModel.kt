package com.marossolutions.welcome.viewmodel

import androidx.lifecycle.ViewModel
import com.marossolutions.navigation.navigator.Navigator
import com.marossolutions.navigation.screen.ScreenHome
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class WelcomeViewModel @Inject constructor(
    private val navigator: Navigator
) : ViewModel() {

    internal fun navigateToHome() {
        navigator.navigateTo(
            screen = ScreenHome,
           /* navigationOptions = NavigationOptions( // TODO enable when feature will be ready
                popUpToScreen = ScreenWelcome,
                popUpToInclusive = true
            )*/
        )
    }
}
