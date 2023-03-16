package com.splanes.apps.dutyfruty.data.infrastructure.di

import com.splanes.apps.dutyfruty.data.features.authentication.datasource.AuthDataSource
import com.splanes.apps.dutyfruty.data.features.authentication.datasource.impl.AuthDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindAuthDataSource(impl: AuthDataSourceImpl): AuthDataSource
}
