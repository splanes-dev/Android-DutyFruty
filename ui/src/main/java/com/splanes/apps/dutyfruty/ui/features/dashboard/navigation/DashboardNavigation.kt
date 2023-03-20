package com.splanes.apps.dutyfruty.ui.features.dashboard.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

object DashboardDestinations {
    val all: List<String>
        get() = listOf(
            Timeline,
            ScheduledTasks,
            UnplannedTasks,
            Profile,
        )
    const val Timeline = "dashboard/timeline"
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
    val navToTimeline: () -> Unit = {
        navController.navigate(DashboardDestinations.Timeline) {
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
