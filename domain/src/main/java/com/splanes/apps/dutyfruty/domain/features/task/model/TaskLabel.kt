package com.splanes.apps.dutyfruty.domain.features.task.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TaskLabel(
    val id: String,
    val name: String,
) : Parcelable
