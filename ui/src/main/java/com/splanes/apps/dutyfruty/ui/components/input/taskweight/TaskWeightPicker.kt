package com.splanes.apps.dutyfruty.ui.components.input.taskweight

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.splanes.apps.dutyfruty.ui.R
import com.splanes.apps.dutyfruty.ui.common.preview.UiPreview
import com.splanes.apps.dutyfruty.ui.theme.DutyFrutyTheme
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

@Composable
fun TaskWeightPicker(
    state: TaskWeightPickerState,
    modifier: Modifier = Modifier,
) {
    val coroutineScope = rememberCoroutineScope()
    val items = TaskWeight.values().toList()

    Column(modifier = modifier) {
        Text(
            text = stringResource(id = R.string.task_weight),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface,
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(items) { weight ->
                TaskWeightPickerItem(
                    weight = weight,
                    isSelected = weight == state.selected,
                    onClick = { coroutineScope.launch { state.onChange(weight) } },
                )
            }
        }
    }
}

@Composable
private fun TaskWeightPickerItem(
    weight: TaskWeight,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    Surface(
        modifier = Modifier
            .size(54.dp)
            .padding(8.dp),
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.run {
                if (isSelected) {
                    onPrimaryContainer
                } else {
                    onSurface.copy(alpha = .5f)
                }
            },
        ),
        shape = CircleShape,
        color = if (isSelected) {
            MaterialTheme.colorScheme.primaryContainer.copy(alpha = .3f)
        } else {
            Color.Transparent
        },
        onClick = onClick,
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                modifier = Modifier.padding(bottom = 4.dp),
                text = weight.value.toString(),
                style = MaterialTheme.typography.titleLarge,
                color = if (isSelected) {
                    MaterialTheme.colorScheme.onPrimaryContainer
                } else {
                    MaterialTheme.colorScheme.onSurface
                },
            )
        }
    }
}

class TaskWeightPickerState(initial: TaskWeight = TaskWeight.One) {
    var selected by mutableStateOf(initial)
        private set
    private val mutex = Mutex()

    suspend fun onChange(weight: TaskWeight) = mutex.withLock {
        this.selected = weight
    }
}

@Composable
fun rememberTaskWeightPickerState(initial: TaskWeight = TaskWeight.One) =
    remember { TaskWeightPickerState(initial) }

@Composable
@UiPreview
private fun TaskWeightPickerPreview() {
    DutyFrutyTheme {
        TaskWeightPicker(
            modifier = Modifier.fillMaxWidth(),
            state = rememberTaskWeightPickerState(),
        )
    }
}
