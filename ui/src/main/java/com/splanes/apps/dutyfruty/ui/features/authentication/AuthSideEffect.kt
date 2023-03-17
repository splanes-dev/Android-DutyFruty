package com.splanes.apps.dutyfruty.ui.features.authentication

import com.splanes.apps.dutyfruty.domain.features.authentication.model.CredentialsData

sealed interface AuthSideEffect {

    object None : AuthSideEffect

    data class SignIn(val credentials: CredentialsData) : AuthSideEffect

    object NavToDashboard : AuthSideEffect
}
