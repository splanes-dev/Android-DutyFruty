package com.splanes.apps.dutyfruty.data.infrastructure.di

import com.splanes.apps.dutyfruty.data.features.authentication.repository.AuthRepositoryImpl
import com.splanes.apps.dutyfruty.domain.features.authentication.repository.AuthRepository
import dagger.Binds

abstract class RepositoryModule {

    @Binds
    abstract fun bindAuthRepository(impl: AuthRepositoryImpl): AuthRepository
}
