package com.splanes.apps.dutyfruty.domain.common

sealed class KnownError : Throwable() {

    object Undefined : KnownError()
}
