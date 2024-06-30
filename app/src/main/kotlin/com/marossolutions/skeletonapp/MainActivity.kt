package com.marossolutions.skeletonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.marossolutions.skeletonapp.navigation.AppNavHost
import com.marossolutions.skeletonapp.navigation.SimpleNavigator
import com.marossolutions.skeletonapp.navigation.screens.ScreenAirportDetail
import com.marossolutions.skeletonapp.navigation.screens.ScreenHome
import com.marossolutions.skeletonapp.navigation.screens.ScreenSplash
import com.marossolutions.skeletonapp.navigation.screens.ScreenWelcome
import com.marossolutions.skeletonapp.ui.detail.AirportDetailScreen
import com.marossolutions.skeletonapp.ui.home.HomeScreen
import com.marossolutions.skeletonapp.ui.splash.SplashScreen

import com.marossolutions.skeletonapp.ui.splash.SplashScreenInitializer
import com.marossolutions.skeletonapp.ui.theme.SkeletonAppTheme
import com.marossolutions.skeletonapp.ui.welcome.WelcomeScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var splashScreenInitializer: SplashScreenInitializer

    @Inject
    lateinit var simpleNavigator: SimpleNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)

        splashScreen.setKeepOnScreenCondition(splashScreenInitializer)

        enableEdgeToEdge()
        setContent {
            SkeletonAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    val navController: NavHostController = rememberNavController()
                    AppNavHost(
                        activity = this,
                        simpleNavigator = simpleNavigator,
                        innerPadding = innerPadding,
                        navController = navController
                    )
                }
            }
        }
    }
}
