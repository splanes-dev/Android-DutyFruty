package com.splanes.apps.dutyfruty.ui.features.authentication

import com.splanes.apps.dutyfruty.domain.common.KnownError
import com.splanes.apps.dutyfruty.domain.features.authentication.model.SignInData
import com.splanes.apps.dutyfruty.domain.features.authentication.usecase.GetSignInDataUseCase
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
    private val getSignInDataUseCase: GetSignInDataUseCase,
) : BaseViewModel() {

    private val viewModelState: MutableStateFlow<ViewModelState> =
        MutableStateFlow(ViewModelState())

    val uiState: StateFlow<AuthState> = viewModelState
        .map { viewModelState -> viewModelState.authState() }
        .eagerly(viewModelState.value.authState())

    init {
        fetchSignInData()
    }

    private fun fetchSignInData() {
        launch {
            viewModelState.update { state -> state.copy(isLoading = true) }
            getSignInDataUseCase()
                .onSuccess { signInData ->
                    viewModelState.update { state ->
                        state.copy(
                            isLoading = false,
                            signInData = signInData,
                        )
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
    }

    private data class ViewModelState(
        val isLoading: Boolean = true,
        val error: KnownError? = null,
        val signInData: SignInData? = null,
    ) {
        fun authState(): AuthState =
            when (signInData) {
                null -> AuthState.SignUp(
                    loading = isLoading,
                    error = error,
                )

                else -> AuthState.AutoSignIn(
                    loading = isLoading,
                    error = error,
                )
            }
    }
}
