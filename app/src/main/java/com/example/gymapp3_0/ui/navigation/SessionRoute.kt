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
    CreateExercise(R.string.create_exercise)
}

fun NavGraphBuilder.sessionListNavigation(
    navController: NavHostController,
    sessionViewModel: SessionViewModel,
    exerciseViewModel: ExerciseViewModel,
    onCanNavigateBackChange: (Boolean) -> Unit,
    onIsNavigationBarUpChange: (Boolean) -> Unit
) {
    navigation(
        startDestination = AddSessionRoutes.Start.name,
        route = Screen.Sessions.route
    ) {

        //MainSessionBody
        composable(
            route = AddSessionRoutes.Start.name
        ) {
            onCanNavigateBackChange(false)
            onIsNavigationBarUpChange(true)
            SessionsMainBody(

                navigateToCreateSession = {
                    navController.navigate(AddSessionRoutes.CreateSession.name)
                },


                navigateToViewSession = { sessionId ->
                    navController.navigate("${AddSessionRoutes.SeeSession.name}/${sessionId}")
                },
                temporaryList = sessionViewModel.uiState.temporaryList as MutableList<ExerciseModel>
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
            onCanNavigateBackChange(true)
            onIsNavigationBarUpChange(false)
            ViewSessionBody(
                sessionId = sessionId,
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }

        //CreateSession
        composable(route = AddSessionRoutes.CreateSession.name) {

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
                onIsNavigationBarUpChange = onIsNavigationBarUpChange,
                onCanNavigateBackChange = onCanNavigateBackChange,
                temporaryList = sessionViewModel.uiState.temporaryList as MutableList<ExerciseModel>
            )
        }

        //AddExercise
        composable(route = AddSessionRoutes.AddExercise.name) {
            onCanNavigateBackChange(true)
            onIsNavigationBarUpChange(false)
            AddExerciseBody(
                navigateBackToCreateSession = {
                    navController.navigate(AddSessionRoutes.CreateSession.name)
                },
                navigateToCreateExercise = {
                    navController.navigate(AddSessionRoutes.CreateExercise.name)
                },
                temporaryList = sessionViewModel.uiState.temporaryList as MutableList<ExerciseModel>
            )
        }

        //CreateExercise
        composable(route = AddSessionRoutes.CreateExercise.name) {
            onCanNavigateBackChange(true)
            onIsNavigationBarUpChange(false)
            CreateExerciseBody(
                addExercise = { exercise ->
                    exerciseViewModel.addExercise(exercise)
                },
                navigateBackToAddExercise = {
                    navController.navigate(AddSessionRoutes.AddExercise.name)
                }
            )
        }
    }
}