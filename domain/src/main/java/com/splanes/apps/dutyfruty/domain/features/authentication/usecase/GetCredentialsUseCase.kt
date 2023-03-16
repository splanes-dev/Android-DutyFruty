package com.splanes.apps.dutyfruty.domain.features.authentication.usecase

import com.splanes.apps.dutyfruty.domain.common.UseCase
import com.splanes.apps.dutyfruty.domain.features.authentication.model.CredentialsData
import com.splanes.apps.dutyfruty.domain.features.authentication.repository.AuthRepository
import javax.inject.Inject

class GetCredentialsUseCase @Inject constructor(
    private val repository: AuthRepository,
) : UseCase<Unit, CredentialsData?>() {

    suspend operator fun invoke() = invoke(Unit)
    override suspend fun execute(params: Unit): CredentialsData? =
        repository.getSignInData()
}
