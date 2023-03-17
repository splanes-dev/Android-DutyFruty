package com.splanes.apps.dutyfruty.ui.features.authentication

import com.splanes.apps.dutyfruty.domain.common.KnownError
import com.splanes.apps.dutyfruty.domain.features.authentication.model.CredentialsData
import com.splanes.apps.dutyfruty.domain.features.authentication.usecase.GetCredentialsUseCase
import com.splanes.apps.dutyfruty.domain.features.authentication.usecase.SignInUseCase
import com.splanes.apps.dutyfruty.domain.features.authentication.usecase.SignUpUseCase
import com.splanes.apps.dutyfruty.ui.common.viewmodel.BaseViewModel
import com.splanes.apps.dutyfruty.ui.features.authentication.components.form.SignUpFormData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val getCredentialsUseCase: GetCredentialsUseCase,
    private val signInUseCase: SignInUseCase,
    private val signUpUseCase: SignUpUseCase,
) : BaseViewModel() {

    private val viewModelState: MutableStateFlow<ViewModelState> =
        MutableStateFlow(ViewModelState())

    val uiState: StateFlow<AuthState> = viewModelState
        .map { viewModelState -> viewModelState.authState() }
        .eagerly(viewModelState.value.authState())

    private val _uiSideEffect: MutableStateFlow<AuthSideEffect> = MutableStateFlow(AuthSideEffect.None)

    val uiSideEffect: StateFlow<AuthSideEffect> = _uiSideEffect.eagerly(AuthSideEffect.None)

    init {
        fetchSignInData()
    }

    private fun fetchSignInData() {
        viewModelState.update { state -> state.copy(isLoading = true) }
        launch {
            getCredentialsUseCase()
                .onSuccess { credentials ->
                    viewModelState.update { state ->
                        state.copy(
                            isLoading = false,
                            credentials = credentials,
                        )
                    }
                    if (credentials != null) {
                        _uiSideEffect.value = AuthSideEffect.SignIn(credentials)
                    }
                }
                .onError { error ->
                    viewModelState.update { state ->
                        state.copy(
                            isLoading = false,
                            error = error,
                        )
                    }
                }
        }
    }

    fun onSignUp(form: SignUpFormData) {
        viewModelState.update { state -> state.copy(isLoading = true) }
        launch {
            val credentials = CredentialsData(
                username = form.username,
                email = form.email,
                password = form.password,
            )
            signUpUseCase(credentials)
                .onSuccess { isSuccess ->
                    viewModelState.update { state -> state.copy(isLoading = false) }
                    if (isSuccess) {
                        _uiSideEffect.value = AuthSideEffect.NavToDashboard
                    } else {
                        viewModelState.update { state -> state.copy(error = KnownError.Undefined) } // TODO: Change to SignUpError
                    }
                }
                .onError { error ->
                    viewModelState.update { state ->
                        state.copy(
                            isLoading = false,
                            error = error,
                        )
                    }
                }
        }
    }

    fun onSignIn(credentials: CredentialsData) {
        viewModelState.update { state -> state.copy(isLoading = true) }
        launch {
            signInUseCase(credentials)
                .onSuccess { isSuccess ->
                    viewModelState.update { state -> state.copy(isLoading = false) }
                    if (isSuccess) {
                        _uiSideEffect.value = AuthSideEffect.NavToDashboard
                    } else {
                        viewModelState.update { state -> state.copy(error = KnownError.Undefined) } // TODO: Change to SignInError
                    }
                }
                .onError { error ->
                    viewModelState.update { state ->
                        state.copy(
                            isLoading = false,
                            error = error,
                        )
                    }
                }
        }
    }

    private data class ViewModelState(
        val isLoading: Boolean = true,
        val error: KnownError? = null,
        val credentials: CredentialsData? = null,
    ) {
        fun authState(): AuthState =
            when (credentials) {
                null -> AuthState.SignUp(
                    loading = isLoading,
                    error = error,
                )

                else -> AuthState.AutoSignIn(
                    loading = isLoading,
                    error = error,
                    credentials = credentials,
                )
            }
    }
}
