package com.tizzone.albumapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tizzone.albumapp.presentation.presentation.Screen
import com.tizzone.albumapp.presentation.theme.TracksAppTheme
import com.tizzone.albumapp.presentation.ui.TracksViewModel
import com.tizzone.albumapp.presentation.ui.screens.TrackScreen
import com.tizzone.albumapp.presentation.ui.screens.TracksScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TracksAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.TracksList.route) {
                        composable(route = Screen.TracksList.route) {
                            navBackStackEntry ->
                            val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)
                            val viewModel: TracksViewModel = viewModel(key = "TracksViewModel", factory = factory)
                            TracksScreen(
                                viewModel = viewModel,
                                onNavigateToTrackDetail = navController::navigate
                            )
                        }
                        composable(
                            route = Screen.TrackDetail.route + "/{trackTitle}/{trackUrl}",
                            arguments = listOf(
                                navArgument("trackTitle") {
                                    type = NavType.StringType
                                },
                                navArgument("trackUrl") {
                                    type = NavType.StringType
                                }
                            )
                        ) {
                            navBackStackEntry ->
                            TrackScreen(
                                trackTitle = navBackStackEntry.arguments?.getString("trackTitle"),
                                url = navBackStackEntry.arguments?.getString("trackUrl")
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TracksAppTheme {
    }
}
