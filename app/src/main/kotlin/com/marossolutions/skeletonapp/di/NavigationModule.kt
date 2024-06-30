package com.marossolutions.skeletonapp.di

import com.marossolutions.skeletonapp.navigation.SimpleNavigator
import com.marossolutions.skeletonapp.navigation.SimpleNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NavigationModule {

    @Singleton
    @Binds
    abstract fun bindSimpleNavigator(impl: SimpleNavigatorImpl): SimpleNavigator
}
