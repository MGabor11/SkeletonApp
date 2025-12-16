package com.marossolutions.configuration.di

import com.marossolutions.common.NetworkConfig
import com.marossolutions.configuration.NetworkConfigImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ConfigurationModule {

    @Binds
    @Singleton
    abstract fun bindNetworkConfig(
        networkConfigImpl: NetworkConfigImpl
    ): NetworkConfig
}

