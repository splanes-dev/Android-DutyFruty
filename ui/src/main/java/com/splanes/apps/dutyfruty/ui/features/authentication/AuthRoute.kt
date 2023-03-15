package com.splanes.apps.dutyfruty.ui.features.authentication

import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun AuthRoute(
    viewModel: AuthViewModel,
    navToDashboard: () -> Unit,
) {
    val authState by viewModel.uiState.collectAsStateWithLifecycle()

    AuthRoute(state = authState)
}

@Composable
fun AuthRoute(
    state: AuthState,
) {
    Crossfade(
        targetState = state,
        label = "AuthRoute Anim",
    ) { authState ->
        when (authState) {
            AuthState.Loading -> AuthLoadingScreen()
            AuthState.NotSignUp -> AuthSignUpScreen()
        }
    }
}
