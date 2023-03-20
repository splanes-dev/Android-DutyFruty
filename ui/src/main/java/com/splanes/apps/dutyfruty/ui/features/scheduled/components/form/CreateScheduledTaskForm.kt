package com.splanes.apps.dutyfruty.ui.features.scheduled.components.form

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.splanes.apps.dutyfruty.ui.R
import com.splanes.apps.dutyfruty.ui.common.preview.UiPreview
import com.splanes.apps.dutyfruty.ui.components.input.taskweight.TaskWeightPicker
import com.splanes.apps.dutyfruty.ui.components.input.taskweight.rememberTaskWeightPickerState
import com.splanes.apps.dutyfruty.ui.components.input.text.TextInput
import com.splanes.apps.dutyfruty.ui.components.input.text.TextInputVisuals
import com.splanes.apps.dutyfruty.ui.components.input.text.rememberTextInputState
import com.splanes.apps.dutyfruty.ui.theme.DutyFrutyTheme

@Composable
fun CreateScheduledTaskForm(
    modifier: Modifier = Modifier,
    onSubmit: () -> Unit,
) {
    val nameState = rememberTextInputState()
    val weightState = rememberTaskWeightPickerState()

    Column(modifier = modifier.fillMaxWidth()) {
        TextInput(
            state = nameState,
            visuals = TextInputVisuals(label = stringResource(id = R.string.task_name)),
        )

        Spacer(modifier = Modifier.height(16.dp))

        TaskWeightPicker(
            modifier = modifier.fillMaxWidth(),
            state = weightState,
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
@UiPreview
private fun CreateScheduledTaskFormPreview() {
    DutyFrutyTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.surface)
                .padding(16.dp),
        ) {
            CreateScheduledTaskForm(modifier = Modifier.fillMaxSize(), {})
        }
    }
}
