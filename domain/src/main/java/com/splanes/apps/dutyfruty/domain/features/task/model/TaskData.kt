package com.splanes.apps.dutyfruty.domain.features.task.model

import android.os.Parcelable

abstract class TaskData(
    open val id: String,
    open val name: String,
    open val label: List<TaskLabel>,
    open val weight: Int,
    open val createdBy: String,
    open val assignedTo: String,
    open val createdOn: String,
    open val updatedOn: String,
    open val sharedWith: List<String>,
) : Parcelable
