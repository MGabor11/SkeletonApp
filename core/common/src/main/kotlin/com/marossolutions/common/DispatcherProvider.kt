package com.marossolutions.common

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    /**
     * Get the default CoroutineDispatcher (Dispatchers.Default).
     */
    val default: CoroutineDispatcher

    /**
     * Get the io CoroutineDispatcher (Dispatchers.IO).
     */
    val io: CoroutineDispatcher
}
