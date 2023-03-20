package com.splanes.apps.dutyfruty.ui.features.scheduled

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.splanes.apps.dutyfruty.ui.R
import com.splanes.apps.dutyfruty.ui.components.buttons.Button
import com.splanes.apps.dutyfruty.ui.components.emptystate.EmptyState
import com.splanes.apps.dutyfruty.ui.components.loader.LoadingBox
import com.splanes.apps.dutyfruty.ui.components.topbar.TopAppBar

@Composable
fun ScheduledTasksEmpty(uiState: ScheduledTaskState.Empty) {
    LoadingBox(loading = uiState.loading) {
        Scaffold(
            modifier = Modifier.fillMaxWidth(),
            topBar = {
                TopAppBar(title = stringResource(id = R.string.scheduled_tasks))
            },
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.weight(1f))

                EmptyState(
                    title = stringResource(id = R.string.scheduled_task_empty),
                    description = stringResource(id = R.string.scheduled_task_empty_description),
                )

                Spacer(modifier = Modifier.height(32.dp))

                Button(text = stringResource(id = R.string.create_task)) {
                }

                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }
}

@Composable
fun ScheduledTasks() {
}

@Composable
fun ScheduledTaskDetail() {
}
