package com.marossolutions.welcome.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.marossolutions.ui.annotation.ThemePreviews
import com.marossolutions.ui.theme.SkeletonAppTheme
import com.marossolutions.welcome.viewmodel.WelcomeViewModel

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