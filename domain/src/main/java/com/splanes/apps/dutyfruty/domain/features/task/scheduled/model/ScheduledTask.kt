package com.splanes.apps.dutyfruty.domain.features.task.scheduled.model

import com.splanes.apps.dutyfruty.domain.features.task.model.TaskData
import com.splanes.apps.dutyfruty.domain.features.task.model.TaskLabel
import kotlinx.parcelize.Parcelize

@Parcelize
data class ScheduledTask(
    override val id: String,
    override val name: String,
    override val label: List<TaskLabel>,
    override val weight: Int,
    override val createdBy: String,
    override val assignedTo: String,
    override val createdOn: String,
    override val updatedOn: String,
    override val sharedWith: List<String>,
    val schedules: List<Schedule>,
) : TaskData(
    id = id,
    name = name,
    label = label,
    weight = weight,
    createdBy = createdBy,
    assignedTo = assignedTo,
    createdOn = createdOn,
    updatedOn = updatedOn,
    sharedWith = sharedWith,
)
