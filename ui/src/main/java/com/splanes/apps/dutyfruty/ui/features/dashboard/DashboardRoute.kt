package com.splanes.apps.dutyfruty.ui.features.dashboard

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.splanes.apps.dutyfruty.ui.features.dashboard.navigation.DashboardNavGraph
import com.splanes.apps.dutyfruty.ui.features.dashboard.navigation.DashboardNavigationActions

@Composable
fun DashboardRoute() {
    val navController = rememberNavController()
    val navActions = remember(navController) {
        DashboardNavigationActions(navController)
    }
    val currentNavState by navController.currentBackStackEntryAsState()
    DashboardRoute(
        navController = navController,
        navActions = navActions,
        current = currentNavState,
    )
}

@Composable
fun DashboardRoute(
    navController: NavHostController,
    navActions: DashboardNavigationActions,
    current: NavBackStackEntry?,
) {
    DashboardNavGraph(
        navController = navController,
        navActions = navActions,
        current = current,
    )
}
