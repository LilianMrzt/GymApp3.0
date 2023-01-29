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
import androidx.navigation.compose.rememberNavController
import com.example.gymapp3_0.R
import com.example.gymapp3_0.ui.navigation.exerciseListNavigation
import com.example.gymapp3_0.ui.navigation.sessionListNavigation
import com.example.gymapp3_0.ui.screens.components.BottomBar
import com.example.gymapp3_0.ui.viewModels.ExerciseViewModel
import com.example.gymapp3_0.ui.viewModels.SessionViewModel

sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int, val icon: Int
) {
    object Sessions : Screen("Sessions", R.string.sessions, R.drawable.dumbbell_black)
    object Exercises : Screen("Exercise", R.string.exercises, R.drawable.create_exercise)
    object CreateExercise :
        Screen("CreateExercise", R.string.create_exercise, R.drawable.create_exercise)
}

val MainScreens = listOf(
    Screen.Sessions,
    Screen.Exercises,
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScreen() {
    val navController = rememberNavController()

    var currentScreenTitle by remember {
        mutableStateOf(Screen.Sessions.resourceId)
    }

    var canNavigateBack by remember {
        mutableStateOf(false)
    }

    var isBottomBarUp by remember {
        mutableStateOf(true)
    }

    Scaffold(
        bottomBar = {
            if (isBottomBarUp) {
                BottomBar(navController) {
                    currentScreenTitle = it.resourceId
                }
            }
        },
        containerColor = MaterialTheme.colorScheme.background

    ) { innerPadding ->
        AppBody(
            navController = navController,
            modifier = Modifier,
            innerPadding = innerPadding,
            onCanNavigateBackChange = {
                canNavigateBack = it
            },
            onIsNavigationBarUpChange = {
                isBottomBarUp = it
            },
            screenTitle = currentScreenTitle,
            canNavigateBack = canNavigateBack
        )
    }
}

@Composable
fun AppBody(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    innerPadding: PaddingValues = PaddingValues(Dp(10.0f)),
    sessionViewModel: SessionViewModel = hiltViewModel(),
    exerciseViewModel: ExerciseViewModel = hiltViewModel(),
    onCanNavigateBackChange: (Boolean) -> Unit,
    onIsNavigationBarUpChange: (Boolean) -> Unit,
    @StringRes screenTitle: Int,
    canNavigateBack: Boolean,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Sessions.route,
        modifier = Modifier.padding(innerPadding)
    ) {
        sessionListNavigation(
            navController = navController,
            sessionViewModel = sessionViewModel,
            exerciseViewModel = exerciseViewModel,
            onCanNavigateBackChange = onCanNavigateBackChange,
            onIsNavigationBarUpChange = onIsNavigationBarUpChange,
            screenTitle = screenTitle,
        )
        exerciseListNavigation(
            navController = navController,
            exerciseViewModel = exerciseViewModel,
            screenTitle = screenTitle,
            onIsNavigationBarUpChange = onIsNavigationBarUpChange,
        )
    }
}