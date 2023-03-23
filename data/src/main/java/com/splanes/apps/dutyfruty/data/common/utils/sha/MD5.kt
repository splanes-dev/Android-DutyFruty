package com.splanes.apps.dutyfruty.data.common.utils.sha

import com.google.android.gms.common.util.Hex
import java.security.MessageDigest

fun String.md5() =
	MessageDigest.getInstance("MD5")
		.apply { update(toByteArray()) }
		.digest()
		.let(Hex::bytesToStringLowercase)
