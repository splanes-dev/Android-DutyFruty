package com.splanes.apps.dutyfruty.data.features.groups.entity

import com.google.gson.annotations.SerializedName

data class GroupEntity(
    @SerializedName("id") val id: String? = null,
    @SerializedName("owner_email") val owner: String? = null,
    @SerializedName("alias") val alias: String? = null,
    @SerializedName("members_email") val members: List<String>? = null,
    @SerializedName("created_on") val createdOn: Long? = null,
    @SerializedName("group_color") val color: Int? = null,
)
