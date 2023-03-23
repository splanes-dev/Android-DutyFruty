package com.splanes.apps.dutyfruty.domain.features.groups.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Group(
    val id: String,
    val alias: String,
    val owner: GroupMember,
    val members: List<GroupMember>,
    val createdOn: Long,
    val color: GroupColor
) : Parcelable
