package com.example.gymapp3_0.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType.Companion.IntType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.gymapp3_0.R
import com.example.gymapp3_0.core.Constants
import com.example.gymapp3_0.core.Constants.Companion.SESSION_ID
import com.example.gymapp3_0.domain.models.ExerciseModel
import com.example.gymapp3_0.ui.screens.Screen
import com.example.gymapp3_0.ui.screens.session_screens.*
import com.example.gymapp3_0.ui.viewModels.ExerciseViewModel
import com.example.gymapp3_0.ui.viewModels.SessionViewModel

enum class AddSessionRoutes(@StringRes val title: Int) {
    Start(R.string.main_session_screen),
    CreateSession(R.string.create_session),
    SeeSession(R.string.see_session),
    AddExercise(R.string.add_exercise),
    SeeExerciseSets(R.string.see_exercise_sets),
    CreateExercise(R.string.create_exercise)
}

fun NavGraphBuilder.sessionListNavigation(
    navController: NavHostController,
    sessionViewModel: SessionViewModel,
    exerciseViewModel: ExerciseViewModel,
    onCanNavigateBackChange: (Boolean) -> Unit,
    onIsNavigationBarUpChange: (Boolean) -> Unit,
    @StringRes screenTitle: Int,
) {
    navigation(
        startDestination = AddSessionRoutes.Start.name,
        route = Screen.Sessions.route
    ) {

        //MainSessionBody
        composable(
            route = AddSessionRoutes.Start.name
        ) {
            onIsNavigationBarUpChange(true)
            SessionsMainBody(

                navigateToCreateSession = {
                    navController.navigate(AddSessionRoutes.CreateSession.name)
                },


                navigateToViewSession = { sessionId ->
                    navController.navigate("${AddSessionRoutes.SeeSession.name}/${sessionId}")
                },
                temporaryList = sessionViewModel.uiState.temporaryList as MutableList<ExerciseModel>,
                screenTitle = screenTitle,
            )
        }

        //SeeSession
        composable(
            route = "${AddSessionRoutes.SeeSession.name}/{$SESSION_ID}",
            arguments = listOf(
                navArgument(SESSION_ID) {
                    type = IntType
                }
            )
        ) { backStackEntry ->
            val sessionId = backStackEntry.arguments?.getInt(SESSION_ID) ?: 0
            onIsNavigationBarUpChange(false)
            ViewSessionBody(
                sessionId = sessionId,
                screenTitle = screenTitle,
                navController = navController,
                navigateToViewExerciseContent = { exerciseId ->
                    navController.navigate("${AddSessionRoutes.SeeExerciseSets.name}/${exerciseId}")
                }
            )
        }

        //SeeExerciseSets
        composable(
            route = "${AddSessionRoutes.SeeExerciseSets.name}/{${Constants.EXERCISE_ID}}",
            arguments = listOf(
                navArgument(Constants.EXERCISE_ID) {
                    type = IntType
                },
            )
        ) { backStackEntry ->
            val exerciseId = backStackEntry.arguments?.getInt(Constants.EXERCISE_ID) ?: 0
            onIsNavigationBarUpChange(false)
            ViewExerciseSetsBody(
                exerciseId = exerciseId,
                screenTitle = screenTitle,
                navController = navController,

                )
        }

        //CreateSession
        composable(route = AddSessionRoutes.CreateSession.name) {
            onIsNavigationBarUpChange(false)
            CreateSessionBody(
                modifier = Modifier,

                addSession = { session ->
                    sessionViewModel.addSession(session)
                },
                navigateToMainSession = {
                    navController.navigate(AddSessionRoutes.Start.name)
                },
                navigateToAddExercises = {
                    navController.navigate(AddSessionRoutes.AddExercise.name)
                },
                onCanNavigateBackChange = onCanNavigateBackChange,
                onIsNavigationBarUpChange = onIsNavigationBarUpChange,
                temporaryList = sessionViewModel.uiState.temporaryList as MutableList<ExerciseModel>,
                screenTitle = screenTitle,
                navController = navController
            )
        }

        //AddExercise
        composable(route = AddSessionRoutes.AddExercise.name) {
            onIsNavigationBarUpChange(false)
            AddExerciseBody(
                navigateBackToCreateSession = {
                    navController.navigate(AddSessionRoutes.CreateSession.name)
                },
                temporaryList = sessionViewModel.uiState.temporaryList as MutableList<ExerciseModel>,
                screenTitle = screenTitle,
                navController = navController,
                navigateToCreateExercise = {
                    navController.navigate(AddSessionRoutes.CreateExercise.name)
                }
            )
        }

        //CreateExercise
        composable(route = AddSessionRoutes.CreateExercise.name) {
            onIsNavigationBarUpChange(false)
            CreateExerciseBody(
                addExercise = { exercise ->
                    exerciseViewModel.addExercise(exercise)
                },
                navigateBackToAddExercise = {
                    navController.navigate(AddSessionRoutes.AddExercise.name)
                },
                screenTitle = screenTitle,
                navController = navController
            )
        }
    }
}