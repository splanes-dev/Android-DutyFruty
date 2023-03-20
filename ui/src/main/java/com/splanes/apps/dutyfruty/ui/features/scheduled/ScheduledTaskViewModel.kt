package com.splanes.apps.dutyfruty.ui.features.scheduled

import com.splanes.apps.dutyfruty.domain.common.KnownError
import com.splanes.apps.dutyfruty.domain.features.task.scheduled.model.ScheduledTask
import com.splanes.apps.dutyfruty.ui.common.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class ScheduledTaskViewModel @Inject constructor() : BaseViewModel() {

    private val viewModelState: MutableStateFlow<ViewModelState> =
        MutableStateFlow(ViewModelState())

    val uiState: StateFlow<ScheduledTaskState> = viewModelState
        .map { viewModelState -> viewModelState.scheduledTaskState() }
        .eagerly(viewModelState.value.scheduledTaskState())

    private data class ViewModelState(
        val loading: Boolean = false,
        val error: KnownError? = null,
        val tasks: List<ScheduledTask> = emptyList(),
        val taskDetail: ScheduledTask? = null,
    ) {

        fun scheduledTaskState(): ScheduledTaskState =
            when {
                taskDetail != null -> {
                    ScheduledTaskState.Detail(
                        loading = loading,
                        error = error,
                        task = taskDetail,
                    )
                }

                tasks.isNotEmpty() -> {
                    ScheduledTaskState.HasTasks(
                        loading = loading,
                        error = error,
                        tasks = tasks,
                    )
                }

                else -> {
                    ScheduledTaskState.Empty(
                        loading = loading,
                        error = error,
                    )
                }
            }
    }
}
