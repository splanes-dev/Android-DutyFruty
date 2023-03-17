package com.splanes.apps.dutyfruty.domain.features.authentication.repository

import com.splanes.apps.dutyfruty.domain.features.authentication.model.CredentialsData

interface AuthRepository {
    suspend fun getSignInData(): CredentialsData?
    suspend fun saveSignInData(credentials: CredentialsData): Boolean
    suspend fun signIn(credentials: CredentialsData): Boolean
    suspend fun signUp(credentials: CredentialsData): Boolean
}
