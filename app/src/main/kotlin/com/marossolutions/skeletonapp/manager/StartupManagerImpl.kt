package com.marossolutions.skeletonapp.manager

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class StartupManagerImpl @Inject constructor() : StartupManager {

    private val initialized = MutableStateFlow(false)

    override fun isAppInitialised(): Flow<Boolean> = initialized

    override suspend fun initializeApp() {
        delay(3000)

        initialized.value = true
    }
}