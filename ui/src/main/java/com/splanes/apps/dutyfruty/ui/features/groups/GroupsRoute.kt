package com.splanes.apps.dutyfruty.ui.features.groups

import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun GroupsRoute(
	viewModel: GroupsViewModel
) {
	val uiState by viewModel.uiState.collectAsStateWithLifecycle()

	GroupsRoute(uiState)
}

@Composable
fun GroupsRoute(
	uiState: GroupsState
) {
	Crossfade(uiState, label = "Groups Route") { groupsState ->
		when (groupsState) {
			is GroupsState.Groups -> GroupsScreen(uiState = groupsState)
		}
	}
}
