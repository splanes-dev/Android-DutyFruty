package com.splanes.apps.dutyfruty.domain.features.authentication.usecase

import com.splanes.apps.dutyfruty.domain.common.UseCase
import com.splanes.apps.dutyfruty.domain.features.authentication.model.CredentialsData
import com.splanes.apps.dutyfruty.domain.features.authentication.repository.AuthRepository
import com.splanes.apps.dutyfruty.domain.features.groups.model.GroupMember
import com.splanes.apps.dutyfruty.domain.features.groups.repository.GroupsRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val authRepository: AuthRepository,
    private val groupsRepository: GroupsRepository
) : UseCase<CredentialsData, Boolean>() {

    override suspend fun execute(params: CredentialsData): Boolean {
        val signUpSuccess = authRepository.signUp(params)
        if (signUpSuccess) {
            authRepository.saveSignInData(params)
            groupsRepository.saveGroupMember(
                GroupMember(
                    username = params.username,
                    email = params.email
                )
            )
        }
        return signUpSuccess
    }
}
