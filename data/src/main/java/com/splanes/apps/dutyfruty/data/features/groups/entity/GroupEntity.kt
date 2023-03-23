package com.splanes.apps.dutyfruty.data.features.groups.entity

import com.google.gson.annotations.SerializedName

data class GroupEntity(
    @SerializedName("id") val id: String?,
    @SerializedName("owner_id") val owner: String?,
    @SerializedName("alias") val alias: String?,
    @SerializedName("members_id") val members: List<String>?,
    @SerializedName("created_on") val createdOn: Long?,
    @SerializedName("group_color") val color: Int?,
)
