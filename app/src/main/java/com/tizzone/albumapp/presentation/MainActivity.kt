package com.tizzone.albumapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tizzone.albumapp.R
import com.tizzone.albumapp.presentation.presentation.Screen
import com.tizzone.albumapp.presentation.theme.TracksAppTheme
import com.tizzone.albumapp.presentation.ui.TracksViewModel
import com.tizzone.albumapp.presentation.ui.components.MyTopAppBar
import com.tizzone.albumapp.presentation.ui.screens.TrackDetails
import com.tizzone.albumapp.presentation.ui.screens.TracksScreen
import com.tizzone.albumapp.utils.TRACKS_VIEWMODEL
import com.tizzone.albumapp.utils.TRACK_TITLE
import com.tizzone.albumapp.utils.TRACK_TITLE_URL
import com.tizzone.albumapp.utils.TRACK_URL
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TracksAppTheme {
                Scaffold(
                    topBar = {
                        MyTopAppBar(R.string.app_name)
                    },
                    containerColor = MaterialTheme.colorScheme.surface,
                    modifier = Modifier.padding(bottom = 5.dp)
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.TracksList.route
                    ) {
                        composable(route = Screen.TracksList.route) { navBackStackEntry ->
                            val factory =
                                HiltViewModelFactory(LocalContext.current, navBackStackEntry)
                            val viewModel: TracksViewModel =
                                viewModel(key = TRACKS_VIEWMODEL, factory = factory)
                            TracksScreen(
                                viewModel = viewModel,
                                onNavigateToTrackDetail = navController::navigate
                            )
                        }
                        composable(
                            route = Screen.TrackDetail.route + TRACK_TITLE_URL,
                            arguments = listOf(
                                navArgument(TRACK_TITLE) {
                                    type = NavType.StringType
                                },
                                navArgument(TRACK_URL) {
                                    type = NavType.StringType
                                }
                            )
                        ) { navBackStackEntry ->
                            TrackDetails(
                                trackTitle = navBackStackEntry.arguments?.getString(TRACK_TITLE),
                                url = navBackStackEntry.arguments?.getString(TRACK_URL)
                            )
                        }
                    }
                }
            }
        }
    }
}
