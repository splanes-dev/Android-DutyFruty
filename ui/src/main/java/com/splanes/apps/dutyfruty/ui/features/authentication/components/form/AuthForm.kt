package com.splanes.apps.dutyfruty.ui.features.authentication.components.form

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Password
import androidx.compose.material.icons.rounded.PersonPin
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.splanes.apps.dutyfruty.ui.R
import com.splanes.apps.dutyfruty.ui.common.preview.UiPreview
import com.splanes.apps.dutyfruty.ui.components.buttons.Button
import com.splanes.apps.dutyfruty.ui.components.input.text.TextInput
import com.splanes.apps.dutyfruty.ui.components.input.text.TextInputValidator
import com.splanes.apps.dutyfruty.ui.components.input.text.TextInputVisuals
import com.splanes.apps.dutyfruty.ui.components.input.text.rememberTextInputState
import com.splanes.apps.dutyfruty.ui.theme.DutyFrutyTheme
import kotlinx.coroutines.launch

@Composable
fun AuthForm(
    modifier: Modifier = Modifier,
    onSubmit: (SignUpFormData) -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()
    val usernameState = rememberTextInputState()
    val emailState = rememberTextInputState()
    val passwordState = rememberTextInputState()

    val mandatoryErrorMessage = stringResource(id = R.string.field_mandatory)
    val emailErrorMessage = stringResource(id = R.string.field_invalid_email_format)
    val passwordErrorMessage = stringResource(id = R.string.field_password_weak)

    Column(modifier = modifier) {
        TextInput(
            state = usernameState,
            visuals = TextInputVisuals(
                label = stringResource(id = R.string.username),
                leadingIcon = Icons.Rounded.PersonPin,
            ),
        )

        TextInput(
            state = emailState,
            visuals = TextInputVisuals(
                label = stringResource(id = R.string.email),
                leadingIcon = Icons.Rounded.Email,
                inputType = TextInputVisuals.InputType.Email,
            ),
        )

        TextInput(
            state = passwordState,
            visuals = TextInputVisuals(
                label = stringResource(id = R.string.password),
                leadingIcon = Icons.Rounded.Password,
                inputType = TextInputVisuals.InputType.Password,
            ),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            text = stringResource(id = R.string.sign_me_up),
            onClick = {
                coroutineScope.launch {
                    val isUsernameValid =
                        usernameState.validate(TextInputValidator.Mandatory(mandatoryErrorMessage))
                    val isEmailValid =
                        emailState.validate(TextInputValidator.Email(emailErrorMessage))
                    val isPasswordValid =
                        passwordState.validate(TextInputValidator.Password(passwordErrorMessage))

                    if (isUsernameValid && isEmailValid && isPasswordValid) {
                        val form = SignUpFormData(
                            username = usernameState.inputValue.text.orEmpty(),
                            email = emailState.inputValue.text.orEmpty(),
                            password = passwordState.inputValue.text.orEmpty(),
                        )
                        onSubmit(form)
                    }
                }
            },
        )
    }
}

@Composable
@UiPreview
private fun AuthFormPreview() {
    DutyFrutyTheme {
        Column(modifier = Modifier.background(MaterialTheme.colorScheme.surface)) {
            AuthForm(onSubmit = {})
        }
    }
}
