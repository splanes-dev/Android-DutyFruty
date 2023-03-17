package com.splanes.apps.dutyfruty.ui.features.authentication

import com.splanes.apps.dutyfruty.domain.common.KnownError
import com.splanes.apps.dutyfruty.domain.features.authentication.model.CredentialsData

sealed interface AuthState {

    data class SignUp(
        val loading: Boolean,
        val error: KnownError? = null,
    ) : AuthState

    data class AutoSignIn(
        val loading: Boolean,
        val error: KnownError? = null,
        val credentials: CredentialsData,
    ) : AuthState
}
