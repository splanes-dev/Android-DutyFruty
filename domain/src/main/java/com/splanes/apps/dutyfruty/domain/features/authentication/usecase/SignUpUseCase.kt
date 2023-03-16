package com.splanes.apps.dutyfruty.domain.features.authentication.usecase

import com.splanes.apps.dutyfruty.domain.common.UseCase
import com.splanes.apps.dutyfruty.domain.features.authentication.model.CredentialsData
import com.splanes.apps.dutyfruty.domain.features.authentication.repository.AuthRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val repository: AuthRepository,
) : UseCase<CredentialsData, Boolean>() {

    override suspend fun execute(params: CredentialsData): Boolean =
        repository.signUp(params)
}
