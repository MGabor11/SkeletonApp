package com.marossolutions.data.di

import com.marossolutions.data.repository.AirportRepositoryImpl
import com.marossolutions.domain.repository.AirportRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAirportRepository(
        airportRepositoryImpl: AirportRepositoryImpl
    ): AirportRepository
}
