package com.marossolutions.skeletonapp.manager

import kotlinx.coroutines.flow.Flow

interface StartupManager {

    fun isAppInitialised(): Flow<Boolean>

    suspend fun initializeApp()
}
