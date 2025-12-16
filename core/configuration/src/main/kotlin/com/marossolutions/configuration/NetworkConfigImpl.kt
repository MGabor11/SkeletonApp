package com.marossolutions.configuration

import com.marossolutions.common.NetworkConfig
import javax.inject.Inject

class NetworkConfigImpl @Inject constructor() : NetworkConfig {
    override val baseUrl: String = BuildConfig.API_ENDPOINT
    override val apiKey: String = BuildConfig.API_KEY
    override val isDebugMode: Boolean = BuildConfig.DEBUG
}