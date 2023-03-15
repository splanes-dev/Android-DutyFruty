package com.splanes.apps.dutyfruty.ui.features.authentication

sealed interface AuthState {

    object Loading : AuthState

    object NotSignUp : AuthState
}
