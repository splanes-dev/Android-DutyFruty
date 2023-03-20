package com.splanes.apps.dutyfruty.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.splanes.apps.dutyfruty.ui.features.authentication.AuthRoute
import com.splanes.apps.dutyfruty.ui.features.authentication.AuthViewModel
import com.splanes.apps.dutyfruty.ui.features.dashboard.DashboardRoute

@Composable
fun DutyFrutyNavGraph(
    navController: NavHostController,
    navActions: DutyFrutyNavActions,
    modifier: Modifier = Modifier,
    startDestination: String = DutyFrutyDestinations.Authentication,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
    ) {
        composable(DutyFrutyDestinations.Authentication) {
            val viewModel: AuthViewModel = hiltViewModel()
            AuthRoute(
                viewModel = viewModel,
                navToDashboard = navActions.navToDashboard,
            )
        }
        composable(DutyFrutyDestinations.Dashboard) {
            DashboardRoute()
        }
    }
}
