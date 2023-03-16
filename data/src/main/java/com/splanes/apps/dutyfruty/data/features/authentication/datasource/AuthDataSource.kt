package com.splanes.apps.dutyfruty.data.features.authentication.datasource

import com.splanes.apps.dutyfruty.data.features.authentication.entity.CredentialsEntity

interface AuthDataSource {
    suspend fun find(): CredentialsEntity?

    suspend fun save(credentials: CredentialsEntity): Boolean

    suspend fun signUp(credentials: CredentialsEntity): Boolean
}
