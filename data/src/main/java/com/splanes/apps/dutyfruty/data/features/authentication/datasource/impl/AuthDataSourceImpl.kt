package com.splanes.apps.dutyfruty.data.features.authentication.datasource.impl

import android.content.SharedPreferences
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.splanes.apps.dutyfruty.data.common.utils.preferences.read
import com.splanes.apps.dutyfruty.data.common.utils.preferences.write
import com.splanes.apps.dutyfruty.data.features.authentication.datasource.AuthDataSource
import com.splanes.apps.dutyfruty.data.features.authentication.entity.CredentialsEntity
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthDataSourceImpl @Inject constructor(
    private val preferences: SharedPreferences,
    private val firebaseAuth: FirebaseAuth,
) : AuthDataSource {

    override suspend fun find(): CredentialsEntity? =
        preferences.read(PreferencesKeyCredentials)

    override suspend fun save(credentials: CredentialsEntity): Boolean =
        preferences.write(PreferencesKeyCredentials, credentials)

    override suspend fun signUp(credentials: CredentialsEntity): Boolean {
        val signUpSuccess = runCatching {
            firebaseAuth.signInWithEmailAndPassword(
                credentials.email.orEmpty(),
                credentials.password.orEmpty(),
            ).await()
        }.isSuccess

        if (signUpSuccess) {
            firebaseAuth.currentUser?.updateProfile(
                UserProfileChangeRequest
                    .Builder()
                    .apply { displayName = credentials.username.orEmpty() }
                    .build(),
            )?.await()
        }

        return signUpSuccess
    }
}

private const val PreferencesKeyCredentials = "user-credentials"
