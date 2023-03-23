package com.splanes.apps.dutyfruty.data.infrastructure.di

import com.splanes.apps.dutyfruty.data.features.groups.datasource.impl.GroupsCache
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Provides
    fun provideGroupsCache() = GroupsCache
}