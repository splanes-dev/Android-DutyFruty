package com.splanes.apps.dutyfruty.data.features.authentication.repository

import com.splanes.apps.dutyfruty.data.features.authentication.datasource.AuthDataSource
import com.splanes.apps.dutyfruty.data.features.authentication.entity.mapper.AuthCredentialsMapper
import com.splanes.apps.dutyfruty.domain.features.authentication.model.CredentialsData
import com.splanes.apps.dutyfruty.domain.features.authentication.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val mapper: AuthCredentialsMapper,
    private val dataSource: AuthDataSource,
) : AuthRepository {

    override suspend fun getSignInData(): CredentialsData? = withContext(Dispatchers.IO) {
        dataSource.find()?.let(mapper::map)
    }

    override suspend fun saveSignInData(credentials: CredentialsData) = withContext(Dispatchers.IO) {
        val credentialsEntity = mapper.map(credentials)
        dataSource.save(credentialsEntity)
    }

    override suspend fun signIn(credentials: CredentialsData): Boolean = withContext(Dispatchers.IO) {
        val credentialsEntity = mapper.map(credentials)
        dataSource.signIn(credentialsEntity)
    }

    override suspend fun signUp(credentials: CredentialsData): Boolean = withContext(Dispatchers.IO) {
        val credentialsEntity = mapper.map(credentials)
        dataSource.signUp(credentialsEntity)
    }
}
