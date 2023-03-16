package com.splanes.apps.dutyfruty.data.features.authentication.repository

import com.splanes.apps.dutyfruty.data.features.authentication.datasource.AuthDataSource
import com.splanes.apps.dutyfruty.data.features.authentication.entity.mapper.AuthCredentialsMapper
import com.splanes.apps.dutyfruty.domain.features.authentication.model.CredentialsData
import com.splanes.apps.dutyfruty.domain.features.authentication.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val mapper: AuthCredentialsMapper,
    private val dataSource: AuthDataSource,
) : AuthRepository {

    override suspend fun getSignInData(): CredentialsData? =
        dataSource.find()?.let(mapper::map)

    override suspend fun signIn(credentials: CredentialsData): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun signUp(credentials: CredentialsData): Boolean {
        val credentialsEntity = mapper.map(credentials)
        return dataSource.signUp(credentialsEntity)
    }
}
