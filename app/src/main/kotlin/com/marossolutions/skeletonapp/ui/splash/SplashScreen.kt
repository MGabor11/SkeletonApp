package com.marossolutions.skeletonapp.ui.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.marossolutions.skeletonapp.viewmodel.SplashViewModel

@Composable
internal fun SplashScreen(viewModel: SplashViewModel = hiltViewModel()) {

    val isInitialized by viewModel.initialized.collectAsStateWithLifecycle()

    LaunchedEffect(isInitialized) {
        if (isInitialized) {
            viewModel.showStartScreen()
        }
    }
}