package com.marossolutions.skeletonapp.di

import com.marossolutions.skeletonapp.service.DispatcherProvider
import com.marossolutions.skeletonapp.service.DispatcherProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule {

    @Singleton
    @Binds
    abstract fun bindDispatcherProvider(impl: DispatcherProviderImpl): DispatcherProvider
}
