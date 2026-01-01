package com.marossolutions.welcome.navigation

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import com.marossolutions.navigation.screen.ScreenWelcome
import com.marossolutions.welcome.ui.WelcomeScreen

fun EntryProviderScope<NavKey>.welcomeEntry() {
    entry<ScreenWelcome> {
        WelcomeScreen()
    }
}
