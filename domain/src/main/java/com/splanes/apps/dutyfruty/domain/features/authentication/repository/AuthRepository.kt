package com.splanes.apps.dutyfruty.domain.features.authentication.repository

import com.splanes.apps.dutyfruty.domain.features.authentication.model.SignInData

interface AuthRepository {
    suspend fun getSignInData(): SignInData?
}
