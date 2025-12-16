package com.marossolutions.skeletonapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.marossolutions.navigation.navigator.Navigator
import com.marossolutions.navigation.rememberNavigationState
import com.marossolutions.navigation.screen.AppScreen
import com.marossolutions.navigation.screen.ScreenWelcome
import com.marossolutions.skeletonapp.navigation.NavigationRoot
import com.marossolutions.ui.theme.SkeletonAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigator: Navigator

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navigationState = rememberNavigationState(ScreenWelcome)
            LaunchedEffect(Unit) {
                navigator.setNavigationState(navigationState)
            }

            SkeletonAppTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary,
                            ),
                            title = {
                                val titleId by remember {
                                    derivedStateOf {
                                        (navigationState.currentNavKey as? AppScreen)?.titleId
                                    }
                                }
                                titleId?.let {
                                    Text(stringResource(it))
                                }
                            },
                            navigationIcon = {
                                val showBackButton by remember {
                                    derivedStateOf {
                                        navigationState.backStackSize > 1
                                    }
                                }

                                if (showBackButton) {
                                    IconButton(onClick = { navigator.navigateUp() }) {
                                        Icon(
                                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                            contentDescription = null
                                        )
                                    }
                                }
                            }
                        )
                    },
                ) { innerPadding ->
                    NavigationRoot(
                        backStack = navigationState.backStack,
                        onBackPress = { navigator.navigateUp() },
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}
