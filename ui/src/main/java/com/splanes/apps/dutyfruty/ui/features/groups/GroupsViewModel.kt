package com.splanes.apps.dutyfruty.ui.features.groups

import com.splanes.apps.dutyfruty.domain.common.KnownError
import com.splanes.apps.dutyfruty.domain.features.groups.usecase.CreateGroupUseCase
import com.splanes.apps.dutyfruty.ui.common.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map

@HiltViewModel
class GroupsViewModel @Inject constructor(
	private val createGroupUseCase: CreateGroupUseCase
) : BaseViewModel() {

	private val viewModelState: MutableStateFlow<ViewModelState> =
		MutableStateFlow(ViewModelState())

	val uiState: StateFlow<GroupsState> = viewModelState
		.map { viewModelState -> viewModelState.groupsState() }
		.eagerly(viewModelState.value.groupsState())



	private data class ViewModelState(
		val loading: Boolean = false,
		val error: KnownError? = null,
	) {
		fun groupsState() = GroupsState.Groups(
			loading = loading,
			error = error
		)
	}
}
