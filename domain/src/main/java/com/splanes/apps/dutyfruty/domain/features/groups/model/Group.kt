package com.splanes.apps.dutyfruty.domain.features.groups.model

import android.os.Parcelable
import java.util.UUID
import kotlinx.parcelize.Parcelize

@Parcelize
data class Group(
    val id: String = UUID.randomUUID().toString(),
    val alias: String,
    val owner: GroupMember,
    val members: List<GroupMember>,
    val createdOn: Long = System.currentTimeMillis(),
    val color: GroupColor
) : Parcelable
