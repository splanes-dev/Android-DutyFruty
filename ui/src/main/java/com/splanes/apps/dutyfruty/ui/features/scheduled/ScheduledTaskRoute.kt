package com.splanes.apps.dutyfruty.ui.features.scheduled

import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ScheduledTaskRoute(viewModel: ScheduledTaskViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    ScheduledTaskRoute(uiState)
}

@Composable
fun ScheduledTaskRoute(
    uiState: ScheduledTaskState,
) {
    Crossfade(targetState = uiState, label = "ScheduledTask Crossfade") { scheduledTaskState ->
        when (scheduledTaskState) {
            is ScheduledTaskState.Detail -> TODO()
            is ScheduledTaskState.Empty -> ScheduledTasksEmpty(scheduledTaskState)
            is ScheduledTaskState.HasTasks -> TODO()
        }
    }
}
