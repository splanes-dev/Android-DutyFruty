package com.splanes.apps.dutyfruty.ui.features.authentication

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.splanes.apps.dutyfruty.ui.R
import com.splanes.apps.dutyfruty.ui.components.anim.LottieAnimation
import com.splanes.apps.dutyfruty.ui.components.loader.LoadingBox
import com.splanes.apps.dutyfruty.ui.features.authentication.components.form.SignUpForm
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
    uiState: AuthState.SignUp,
    onSignUp: (SignUpFormData) -> Unit,
) {
    LoadingBox(
        modifier = Modifier.fillMaxSize(),
        loading = uiState.loading,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.onSurface,
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = stringResource(id = R.string.sign_up_subtitle),
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Justify,
            )

            Spacer(modifier = Modifier.height(16.dp))

            SignUpForm(onSubmit = onSignUp)
        }
    }
}
