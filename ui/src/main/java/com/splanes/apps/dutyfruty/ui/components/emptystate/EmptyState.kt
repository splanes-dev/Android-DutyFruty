package com.splanes.apps.dutyfruty.ui.components.emptystate

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.splanes.apps.dutyfruty.ui.R
import com.splanes.apps.dutyfruty.ui.common.preview.UiPreview
import com.splanes.apps.dutyfruty.ui.components.anim.LottieAnimation
import com.splanes.apps.dutyfruty.ui.theme.DutyFrutyTheme

@Composable
fun EmptyState(
    title: String,
    modifier: Modifier = Modifier,
    description: String? = null,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LottieAnimation(
            modifier = Modifier.size(200.dp),
            resource = R.raw.anim_empty_state,
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
        )

        description?.let {
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = description,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
@UiPreview
fun PreviewEmptyState() {
    DutyFrutyTheme {
        EmptyState(
            modifier = Modifier.fillMaxSize(),
            title = "No results",
            description = "Seems that there is no results yet :(",
        )
    }
}
