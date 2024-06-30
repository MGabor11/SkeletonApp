package com.marossolutions.skeletonapp.di

import android.content.Context
import com.marossolutions.skeletonapp.di.qualifier.VersionName
import com.marossolutions.skeletonapp.BuildConfig
import com.marossolutions.skeletonapp.di.qualifier.ServerUrl
import com.marossolutions.skeletonapp.di.qualifier.VersionCode
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AndroidModule {

    @Provides
    fun provideContext(@ApplicationContext context: Context): Context = context

    @Provides
    @VersionCode
    fun provideVersionCode(): Int = BuildConfig.VERSION_CODE

    @Provides
    @VersionName
    fun provideVersionName(): String = BuildConfig.VERSION_NAME

    @Provides
    @ServerUrl
    fun provideServerUrl(): String = BuildConfig.API_ENDPOINT
}
