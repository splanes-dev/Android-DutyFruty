package com.splanes.apps.dutyfruty.ui.features.groups

import com.splanes.apps.dutyfruty.domain.common.KnownError

sealed interface GroupsState {

	data class Groups(
		val loading: Boolean,
		val error: KnownError?
	) : GroupsState
}
