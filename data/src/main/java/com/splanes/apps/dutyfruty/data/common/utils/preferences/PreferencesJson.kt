package com.splanes.apps.dutyfruty.data.common.utils.preferences

import android.content.SharedPreferences
import androidx.core.content.edit
import com.google.gson.Gson
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun <T> SharedPreferences.write(key: String, obj: T): Boolean =
    suspendCoroutine { continuation ->
        val json = runCatching { Gson().toJson(obj) }.getOrNull()
        if (json != null) {
            edit { putString(key, json) }
            continuation.resume(true)
        } else {
            continuation.resume(false)
        }
    }

suspend inline fun <reified T> SharedPreferences.read(key: String): T? =
    suspendCoroutine { continuation ->
        val json = getString(key, null)
        if (json != null) {
            val obj = runCatching { Gson().fromJson(json, T::class.java) }.getOrNull()
            continuation.resume(obj)
        } else {
            continuation.resume(null)
        }
    }
