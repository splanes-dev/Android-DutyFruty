package com.splanes.apps.dutyfruty.data.common.utils.firebase

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


suspend fun <T> DatabaseReference.await(block: (DataSnapshot) -> T) : T? =
    suspendCoroutine {  continuation ->
        addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                continuation.resume(block(snapshot))
            }

            override fun onCancelled(error: DatabaseError) {
                continuation.resume(null)
            }
        })
    }