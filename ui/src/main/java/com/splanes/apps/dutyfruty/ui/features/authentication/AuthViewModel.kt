package com.splanes.apps.dutyfruty.ui.features.authentication

import com.splanes.apps.dutyfruty.domain.common.KnownError
import com.splanes.apps.dutyfruty.domain.features.authentication.SignInData
import com.splanes.apps.dutyfruty.ui.common.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor() : BaseViewModel() {

    private val viewModelState: MutableStateFlow<ViewModelState> =
        MutableStateFlow(ViewModelState())

    val uiState: StateFlow<AuthState> = viewModelState
        .map { viewModelState -> viewModelState.authState() }
        .eagerly(viewModelState.value.authState())

    private data class ViewModelState(
        val isLoading: Boolean = true,
        val error: KnownError? = null,
        val signInData: SignInData? = null,
    ) {
        fun authState(): AuthState =
            when {
                isLoading -> AuthState.Loading
                signInData == null -> AuthState.NotSignUp
                else -> AuthState.Loading
            }
    }
}
