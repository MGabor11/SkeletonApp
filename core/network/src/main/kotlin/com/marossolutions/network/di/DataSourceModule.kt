package com.marossolutions.network.di

import com.marossolutions.network.datasource.AirportRemoteDataSource
import com.marossolutions.network.datasource.AirportRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindAirportRemoteDataSource(
        airportRemoteDataSourceImpl: AirportRemoteDataSourceImpl
    ): AirportRemoteDataSource
}
