package com.splanes.apps.dutyfruty.domain.features.authentication.model

data class CredentialsData(
    val username: String,
    val email: String,
    val password: String,
) {
    companion object {
        val Empty = CredentialsData(
            username = "",
            email = "",
            password = "",
        )
    }
}
