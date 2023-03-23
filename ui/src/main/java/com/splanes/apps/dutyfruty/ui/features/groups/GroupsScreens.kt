package com.splanes.apps.dutyfruty.ui.features.groups

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.splanes.apps.dutyfruty.ui.R
import com.splanes.apps.dutyfruty.ui.common.preview.UiPreview
import com.splanes.apps.dutyfruty.ui.components.loader.LoadingBox
import com.splanes.apps.dutyfruty.ui.components.topbar.TopAppBar
import com.splanes.apps.dutyfruty.ui.theme.DutyFrutyTheme

@Composable
fun GroupsScreen(
	uiState: GroupsState.Groups
) {
	LoadingBox(loading = uiState.loading) {
		Scaffold(
			modifier = Modifier.fillMaxSize(),
			topBar = {
				TopAppBar(title = stringResource(id = R.string.groups_labels))
			}
		) { innerPaddings ->
			Column(
				modifier = Modifier
					.fillMaxSize()
					.padding(innerPaddings),
			) {
				Text(
					text = stringResource(id = R.string.groups),
					style = MaterialTheme.typography.displayMedium,
					color = MaterialTheme.colorScheme.onSurface
				)

				Text(
					text = stringResource(id = R.string.labels),
					style = MaterialTheme.typography.displayMedium,
					color = MaterialTheme.colorScheme.onSurface
				)
			}
		}
	}
}

@Composable
@UiPreview
private fun GroupsScreenPreview() {
	DutyFrutyTheme {
		GroupsScreen(GroupsState.Groups(loading = false, error = null))
	}
}
