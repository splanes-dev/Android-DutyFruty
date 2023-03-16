package com.splanes.apps.dutyfruty.data.features.authentication.entity.mapper

import com.splanes.apps.dutyfruty.data.features.authentication.entity.CredentialsEntity
import com.splanes.apps.dutyfruty.domain.features.authentication.model.CredentialsData
import javax.inject.Inject

class AuthCredentialsMapper @Inject constructor() {

    fun map(entity: CredentialsEntity): CredentialsData =
        CredentialsData(
            username = entity.username.orEmpty(),
            email = entity.email.orEmpty(),
            password = entity.password.orEmpty(),
        )

    fun map(credentialsData: CredentialsData): CredentialsEntity =
        CredentialsEntity(
            username = credentialsData.username,
            email = credentialsData.email,
            password = credentialsData.password,
        )
}
