package com.splanes.apps.dutyfruty.domain.features.groups.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.UUID

@Parcelize
data class GroupMember(
    val id: String = UUID.randomUUID().toString(),
    val username: String,
    val email: String,
) : Parcelable
