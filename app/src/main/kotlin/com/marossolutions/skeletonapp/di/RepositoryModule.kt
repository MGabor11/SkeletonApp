package com.marossolutions.skeletonapp.di

import com.marossolutions.skeletonapp.repository.AirportRepository
import com.marossolutions.skeletonapp.repository.AirportRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindAirportRepository(impl: AirportRepositoryImpl): AirportRepository
}
