package com.marossolutions.skeletonapp.ui.welcome

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.marossolutions.skeletonapp.ui.theme.SkeletonAppTheme
import com.marossolutions.skeletonapp.ui.theme.annotation.ThemePreviews
import com.marossolutions.skeletonapp.viewmodel.WelcomeViewModel

@Composable
internal fun WelcomeScreen(viewModel: WelcomeViewModel = hiltViewModel()) {

    WelcomeScreenContent(
        navigateToHome = viewModel::navigateToHome
    )
}

@Composable
private fun WelcomeScreenContent(
    navigateToHome: () -> Unit,
) {
    Column {
        Text(text = "WELCOME")
        Button(
            onClick = navigateToHome
        ) {
            Text(text = "Simple Button")
        }
    }
}

@ThemePreviews
@Composable
private fun WelcomeScreenContentPreview() {
    SkeletonAppTheme {
        WelcomeScreenContent(
            navigateToHome = {}
        )
    }
}