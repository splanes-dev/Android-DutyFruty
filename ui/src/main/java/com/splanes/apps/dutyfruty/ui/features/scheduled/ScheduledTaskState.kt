package com.splanes.apps.dutyfruty.ui.features.scheduled

import com.splanes.apps.dutyfruty.domain.common.KnownError
import com.splanes.apps.dutyfruty.domain.features.task.scheduled.model.ScheduledTask

sealed interface ScheduledTaskState {

    data class Empty(
        val loading: Boolean,
        val error: KnownError?,
    ) : ScheduledTaskState

    data class HasTasks(
        val loading: Boolean,
        val error: KnownError?,
        val tasks: List<ScheduledTask>,
    ) : ScheduledTaskState

    data class Detail(
        val loading: Boolean,
        val error: KnownError?,
        val task: ScheduledTask,
    ) : ScheduledTaskState
}
