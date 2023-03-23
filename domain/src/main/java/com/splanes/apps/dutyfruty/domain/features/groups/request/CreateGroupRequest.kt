package com.splanes.apps.dutyfruty.domain.features.groups.request

import com.splanes.apps.dutyfruty.domain.features.groups.model.GroupColor

data class CreateGroupRequest(
    val alias: String,
    val members: List<String>,
    val color: GroupColor
)
