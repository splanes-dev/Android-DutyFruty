package com.splanes.apps.dutyfruty.ui.features.dashboard.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

object DashboardDestinations {
    val all: List<String>
        get() = listOf(
            Groups,
            ScheduledTasks,
            UnplannedTasks,
            Profile,
        )
    const val Groups = "dashboard/groups"
    const val ScheduledTasks = "dashboard/scheduled-tasks"
    const val UnplannedTasks = "dashboard/unplanned-tasks"
    const val Profile = "dashboard/profile"
}

class DashboardNavigationActions(private val navController: NavHostController) {
    val navToProfile: () -> Unit = {
        navController.navigate(DashboardDestinations.Profile) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            restoreState = true
        }
    }
    val navToGroups: () -> Unit = {
        navController.navigate(DashboardDestinations.Groups) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            restoreState = true
        }
    }
    val navToUnplannedTasks: () -> Unit = {
        navController.navigate(DashboardDestinations.UnplannedTasks) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            restoreState = true
        }
    }
    val navToScheduledTasks: () -> Unit = {
        navController.navigate(DashboardDestinations.ScheduledTasks) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            restoreState = true
        }
    }
}
