package com.splanes.apps.dutyfruty.ui

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

object DutyFrutyDestinations {
    const val Authentication = "authentication"
    const val Dashboard = "dashboard"
}

class DutyFrutyNavActions(private val navController: NavHostController) {
    val navToDashboard: () -> Unit = {
        navController.navigate(DutyFrutyDestinations.Dashboard) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}