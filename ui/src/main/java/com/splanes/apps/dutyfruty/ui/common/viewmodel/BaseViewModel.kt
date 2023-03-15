package com.splanes.apps.dutyfruty.ui.common.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.splanes.apps.dutyfruty.domain.common.KnownError
import com.splanes.apps.dutyfruty.domain.common.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    fun <T> Flow<T>.eagerly(initial: T) = stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        initial,
    )

    protected fun launch(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(block = block)
    }

    protected fun <T> UseCase.Result<T>.onSuccess(block: (T) -> Unit): UseCase.Result<T> =
        apply {
            if (this is UseCase.Success) {
                block(result)
            }
        }

    protected fun <T> UseCase.Result<T>.onError(block: (KnownError) -> Unit): UseCase.Result<T> =
        apply {
            if (this is UseCase.Failure) {
                block(error)
            }
        }
}
