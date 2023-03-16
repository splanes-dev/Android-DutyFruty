package com.splanes.apps.dutyfruty.domain.features.authentication.usecase

import com.splanes.apps.dutyfruty.domain.common.UseCase
import com.splanes.apps.dutyfruty.domain.features.authentication.model.SignInData
import com.splanes.apps.dutyfruty.domain.features.authentication.repository.AuthRepository
import javax.inject.Inject

class GetSignInDataUseCase @Inject constructor(
    private val repository: AuthRepository,
) : UseCase<Unit, SignInData?>() {

    suspend operator fun invoke() = invoke(Unit)
    override suspend fun execute(params: Unit): SignInData? =
        repository.getSignInData()
}
