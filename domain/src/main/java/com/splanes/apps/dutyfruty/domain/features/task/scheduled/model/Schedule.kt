package com.splanes.apps.dutyfruty.domain.features.task.scheduled.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.DayOfWeek
import java.util.Date

@Parcelize
data class Schedule(
    val startAt: Date,
    val duration: Int,
    val daysOfWeek: DayOfWeek,
    val hasNotification: Boolean,
) : Parcelable
