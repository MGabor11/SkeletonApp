package com.marossolutions.skeletonapp.navigation

import android.app.Activity
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.marossolutions.skeletonapp.navigation.screens.AppScreen
import com.marossolutions.skeletonapp.navigation.screens.ScreenAirportDetail
import com.marossolutions.skeletonapp.navigation.screens.ScreenHome
import com.marossolutions.skeletonapp.navigation.screens.ScreenSplash
import com.marossolutions.skeletonapp.navigation.screens.ScreenWelcome
import com.marossolutions.skeletonapp.ui.detail.AirportDetailScreen
import com.marossolutions.skeletonapp.ui.home.HomeScreen
import com.marossolutions.skeletonapp.ui.splash.SplashScreen
import com.marossolutions.skeletonapp.ui.welcome.WelcomeScreen
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun AppNavHost(
    activity: Activity,
    simpleNavigator: SimpleNavigator,
    innerPadding: PaddingValues,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        modifier = Modifier.padding(innerPadding),
        startDestination = ScreenSplash
    ) {
        composable<ScreenSplash> {
            SplashScreen()
        }
        composable<ScreenWelcome> {
            WelcomeScreen()
        }
        composable<ScreenHome> {
            HomeScreen()
        }
        composable<ScreenAirportDetail> {
            val args = it.toRoute<ScreenAirportDetail>()
            AirportDetailScreen(airportId = args.airportId)
        }
    }

    LaunchedEffect(Unit) {
        simpleNavigator.navigationEvents
            .onEach { navigateEvent ->
                when (navigateEvent) {
                    is NavigationEvent.ForwardNavigation -> navController.navigate(navigateEvent.screen) {
                        navigateEvent.navigationOptions?.let { navigationOptions ->
                            popUpTo(navigationOptions.popUpToScreen) {
                                inclusive = navigationOptions.popUpToInclusive
                            }
                        }
                    }

                    NavigationEvent.NavigateUp -> {
                        if (!navController.navigateUp()) {
                            activity.finish()
                        }
                    }
                }
            }
            .launchIn(this)
    }
}
