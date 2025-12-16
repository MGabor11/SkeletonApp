package com.marossolutions.navigation.screen

import androidx.annotation.StringRes
import androidx.navigation3.runtime.NavKey

interface AppScreen : NavKey {
    @get:StringRes
    val titleId: Int?
        get() = null
}
