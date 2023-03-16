package com.splanes.apps.dutyfruty.ui.features.authentication

import com.splanes.apps.dutyfruty.domain.common.KnownError

sealed interface AuthState {

    data class SignUp(
        val loading: Boolean,
        val error: KnownError? = null,
    ) : AuthState

    data class AutoSignIn(
        val loading: Boolean,
        val error: KnownError? = null,
    ) : AuthState
}
