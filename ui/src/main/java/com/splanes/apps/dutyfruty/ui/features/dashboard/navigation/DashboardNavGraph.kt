package com.splanes.apps.dutyfruty.ui.features.dashboard.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Event
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Task
import androidx.compose.material.icons.rounded.Timeline
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.splanes.apps.dutyfruty.ui.R
import com.splanes.apps.dutyfruty.ui.features.scheduled.ScheduledTaskRoute
import com.splanes.apps.dutyfruty.ui.features.scheduled.ScheduledTaskViewModel

@Composable
fun DashboardNavGraph(
    navController: NavHostController,
    navActions: DashboardNavigationActions,
    current: NavBackStackEntry?,
    modifier: Modifier = Modifier,
    startDestination: String = DashboardDestinations.Timeline,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        NavHost(
            modifier = modifier.weight(1f),
            navController = navController,
            startDestination = startDestination,
        ) {
            composable(DashboardDestinations.Timeline) {
            }
            composable(DashboardDestinations.ScheduledTasks) {
                val viewModel: ScheduledTaskViewModel = hiltViewModel()
                ScheduledTaskRoute(viewModel)
            }
            composable(DashboardDestinations.Profile) {
            }
            composable(DashboardDestinations.UnplannedTasks) {
            }
        }
        BottomNavigation(
            modifier = Modifier.fillMaxWidth(),
            backgroundColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        ) {
            DashboardDestinations.all.forEach { destination ->

                val label = when (destination) {
                    DashboardDestinations.Profile -> R.string.profile
                    DashboardDestinations.Timeline -> R.string.timeline
                    DashboardDestinations.ScheduledTasks -> R.string.scheduled_tasks
                    DashboardDestinations.UnplannedTasks -> R.string.unplanned_tasks
                    else -> error("Destination not registered")
                }.let { id -> stringResource(id) }

                BottomNavigationItem(
                    selected = current.isSelected(destination),
                    onClick = when (destination) {
                        DashboardDestinations.Profile -> navActions.navToProfile
                        DashboardDestinations.Timeline -> navActions.navToTimeline
                        DashboardDestinations.ScheduledTasks -> navActions.navToScheduledTasks
                        DashboardDestinations.UnplannedTasks -> navActions.navToUnplannedTasks
                        else -> error("Destination not registered")
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Rounded.run {
                                when (destination) {
                                    DashboardDestinations.Profile -> Person
                                    DashboardDestinations.Timeline -> Timeline
                                    DashboardDestinations.ScheduledTasks -> Event
                                    DashboardDestinations.UnplannedTasks -> Task
                                    else -> error("Destination not registered")
                                }
                            },
                            contentDescription = label,
                            tint = MaterialTheme.colorScheme.run {
                                if (current.isSelected(destination)) {
                                    onPrimaryContainer
                                } else {
                                    onPrimaryContainer.copy(alpha = .3f)
                                }
                            },
                        )
                    },
                    label = {
                        Text(
                            text = label,
                            style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight.Medium,
                            ),
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            textAlign = TextAlign.Center,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    },
                    alwaysShowLabel = false,
                    selectedContentColor = MaterialTheme.colorScheme.onPrimary,
                    unselectedContentColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = .3f),
                )
            }
        }
    }
}

private fun NavBackStackEntry?.isSelected(route: String) =
    this?.destination?.route == route
