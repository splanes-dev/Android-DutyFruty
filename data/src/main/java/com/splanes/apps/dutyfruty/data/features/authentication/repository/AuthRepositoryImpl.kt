package com.splanes.apps.dutyfruty.data.features.authentication.repository

import com.splanes.apps.dutyfruty.domain.features.authentication.model.SignInData
import com.splanes.apps.dutyfruty.domain.features.authentication.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor() : AuthRepository {

    override suspend fun getSignInData(): SignInData? {
        TODO("Not yet implemented")
    }
}
