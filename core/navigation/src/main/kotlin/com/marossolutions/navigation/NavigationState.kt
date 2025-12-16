/*
 * Copyright 2025 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.marossolutions.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import com.marossolutions.navigation.screen.AppScreen

/**
 * Create a navigation state that persists config changes and process death.
 */
@Composable
fun rememberNavigationState(
    startKey: AppScreen,
): NavigationState {
    val backStack = rememberNavBackStack(startKey)

    return remember(startKey) {
        NavigationState(
            backStack = backStack,
        )
    }
}

class NavigationState(
    val backStack: NavBackStack<NavKey>,
) {
    val currentNavKey: NavKey by derivedStateOf { backStack.last() }

    val backStackSize: Int by derivedStateOf { backStack.size }
}
