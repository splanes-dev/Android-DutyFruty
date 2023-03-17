package com.splanes.apps.dutyfruty.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.splanes.apps.dutyfruty.ui.theme.DutyFrutyTheme

@Composable
fun DutyFrutyApp() {
    DutyFrutyTheme {
        val navController = rememberNavController()
        val navActions = remember(navController) {
            DutyFrutyNavActions(navController)
        }

        DutyFrutyNavGraph(
            modifier = Modifier.fillMaxSize(),
            navController = navController,
            navActions = navActions,
        )
    }
}
