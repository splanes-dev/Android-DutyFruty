package com.splanes.apps.dutyfruty.data.features.authentication.entity

import com.google.gson.annotations.SerializedName

data class CredentialsEntity(
    @SerializedName("username") val username: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("password") val password: String?,
)
