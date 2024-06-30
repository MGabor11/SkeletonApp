package com.marossolutions.skeletonapp.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.marossolutions.skeletonapp.repository.model.Airport
import com.marossolutions.skeletonapp.ui.component.FullScreenLoading
import com.marossolutions.skeletonapp.ui.theme.SkeletonAppTheme
import com.marossolutions.skeletonapp.ui.theme.annotation.ThemePreviews
import com.marossolutions.skeletonapp.viewmodel.HomeViewModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList

@Composable
internal fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (val state = uiState) {
        is HomeViewModel.HomeUiState.Loading -> FullScreenLoading()
        is HomeViewModel.HomeUiState.Content -> HomeScreenContent(
            airports = state.airports.toImmutableList(),
            navigateToDetail = viewModel::navigateToDetail
        )
    }
}

@Composable
private fun HomeScreenContent(
    airports: ImmutableList<Airport>,
    navigateToDetail: (String) -> Unit,
) {
    Column {
        Text(text = "HOME")

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(
                items = airports,
                itemContent = { airport ->
                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable { navigateToDetail(airport.id) }) {
                        Text(text = airport.name)
                    }

                }
            )
        }
    }
}

@ThemePreviews
@Composable
private fun HomeScreenContentPreview() {
    SkeletonAppTheme {
        HomeScreenContent(
            airports = persistentListOf(
                Airport("1", "TEST 1"),
                Airport("2", "TEST 2")
            ),
            navigateToDetail = {}
        )
    }
}