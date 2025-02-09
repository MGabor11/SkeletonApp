package com.marossolutions.skeletonapp.service

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class DispatcherProviderImpl @Inject constructor() : DispatcherProvider {
    override val main: CoroutineDispatcher = Dispatchers.Main

    override val default: CoroutineDispatcher = Dispatchers.Default

    override val io: CoroutineDispatcher = Dispatchers.IO
}