package com.example.gymapp3_0.ui.screens

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gymapp3_0.R
import com.example.gymapp3_0.ui.navigation.sessionListNavigation
import com.example.gymapp3_0.ui.screens.components.BottomBar
import com.example.gymapp3_0.ui.screens.components.TopBar
import com.example.gymapp3_0.ui.viewModels.SessionViewModel

sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int, val icon: Int
) {
    object Sessions : Screen("Sessions", R.string.sessions, R.drawable.dumbbell_black)
    object Calendar : Screen("Calendar", R.string.calendar, R.drawable.calendar_black)
    object Timer : Screen("Timer", R.string.timer, R.drawable.stopwatch_black)
}

val MainScreens = listOf(
    Screen.Sessions,
    Screen.Timer,
    Screen.Calendar,
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScreen() {
    val navController = rememberNavController()

    var currentScreenTitle by remember {
        mutableStateOf(Screen.Sessions.resourceId)
    }

    Scaffold(
        topBar = {
            TopBar(title = currentScreenTitle)
        },

        bottomBar = {
            BottomBar(navController) {
                currentScreenTitle = it.resourceId
            }
        },
        containerColor = MaterialTheme.colorScheme.surface

    ) { innerPadding ->
        AppBody(
            navController = navController,
            modifier = Modifier,
            innerPadding = innerPadding
        )
    }
}

@Composable
fun AppBody(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    innerPadding: PaddingValues = PaddingValues(Dp(10.0f)),
    viewModel: SessionViewModel = hiltViewModel()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Sessions.route,
        modifier = Modifier.padding(innerPadding)
    ) {
        sessionListNavigation(
            navController = navController,
            viewModel = viewModel
        )


        //composable(Screen.Sessions.route) { SessionsMainBody() }
        composable(Screen.Calendar.route) { CalendarBody(navController) }
        composable(Screen.Timer.route) { TimerBody(navController) }
    }
}