package com.marossolutions.skeletonapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marossolutions.skeletonapp.manager.StartupManager
import com.marossolutions.skeletonapp.navigation.NavigationOptions
import com.marossolutions.skeletonapp.navigation.SimpleNavigator
import com.marossolutions.skeletonapp.navigation.screens.ScreenSplash
import com.marossolutions.skeletonapp.navigation.screens.ScreenWelcome
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class SplashViewModel @Inject constructor(
    startupManager: StartupManager,
    private val navigator: SimpleNavigator
) : ViewModel() {

    internal val initialized = startupManager.isAppInitialised()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = false
        )

    internal fun showStartScreen() {
        navigator.navigateTo(
            screen = ScreenWelcome,
            navigationOptions = NavigationOptions(
                popUpToScreen = ScreenSplash,
                popUpToInclusive = true
            )
        )
    }
}
