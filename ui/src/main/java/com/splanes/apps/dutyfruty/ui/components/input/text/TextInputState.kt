package com.splanes.apps.dutyfruty.ui.components.input.text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class TextInputState(private val initial: String) {

    var inputValue: TextInputValue by mutableStateOf(TextInputValue.Normal(initial))
        private set

    var hasChanged: Boolean by mutableStateOf(false)
        private set

    private val mutex: Mutex = Mutex()

    suspend fun onChange(text: String) = mutex.withLock {
        inputValue = TextInputValue.Normal(text)
        hasChanged = text != initial
    }

    suspend fun clear() = onChange("")

    suspend fun validate(vararg validators: TextInputValidator) = mutex.withLock {
        val validatorFailed = validators.find { v -> !v.isValid(inputValue.text.orEmpty()) }
        inputValue = validatorFailed?.let { failed ->
            TextInputValue.Error(inputValue.text, failed.error)
        } ?: TextInputValue.Normal(inputValue.text.orEmpty())
        inputValue !is TextInputValue.Error
    }
}

@Composable
fun rememberTextInputState(initial: String = "") = remember { TextInputState(initial) }
