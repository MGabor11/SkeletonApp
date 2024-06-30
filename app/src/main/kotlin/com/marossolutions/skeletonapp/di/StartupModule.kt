package com.marossolutions.skeletonapp.di

import com.marossolutions.skeletonapp.manager.StartupManager
import com.marossolutions.skeletonapp.manager.StartupManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class StartupModule {

    @Binds
    @Singleton
    abstract fun bindStartupManager(impl: StartupManagerImpl): StartupManager
}
