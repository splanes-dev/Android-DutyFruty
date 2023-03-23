package com.splanes.apps.dutyfruty.data.features.groups.entity

import com.google.gson.annotations.SerializedName

data class GroupMemberEntity(
    @SerializedName("id") val id: String? = null,
    @SerializedName("username") val username: String? = null,
    @SerializedName("email") val email: String? = null,
)
