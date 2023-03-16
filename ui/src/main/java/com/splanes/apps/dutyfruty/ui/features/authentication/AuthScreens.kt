package com.splanes.apps.dutyfruty.ui.features.authentication

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.splanes.apps.dutyfruty.ui.R
import com.splanes.apps.dutyfruty.ui.components.anim.LottieAnimation
import com.splanes.apps.dutyfruty.ui.features.authentication.components.form.AuthForm
import com.splanes.apps.dutyfruty.ui.features.authentication.components.form.SignUpFormData

@Composable
fun AuthLoadingScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        LottieAnimation(
            modifier = Modifier.size(100.dp),
            resource = R.raw.anim_loading,
        )
    }
}

@Composable
fun AuthSignUpScreen(
    onSignUp: (SignUpFormData) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "", // stringResource(id = R.string.),
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.onSurface,
        )

        Text(
            text = "", // stringResource(id = R.string.),
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onSurface,
        )

        AuthForm(onSubmit = onSignUp)
    }
}
