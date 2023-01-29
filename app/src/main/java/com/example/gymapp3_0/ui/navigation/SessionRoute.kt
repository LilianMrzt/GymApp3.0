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
import com.example.gymapp3_0.ui.screens.session_screens.AddExerciseBody
import com.example.gymapp3_0.ui.screens.session_screens.CreateSessionBody
import com.example.gymapp3_0.ui.screens.session_screens.SessionsMainBody
import com.example.gymapp3_0.ui.screens.session_screens.ViewSessionBody
import com.example.gymapp3_0.ui.viewModels.ExerciseViewModel
import com.example.gymapp3_0.ui.viewModels.SessionViewModel

enum class AddSessionRoutes(@StringRes val title: Int) {
    Start(R.string.main_session_screen),
    CreateSession(R.string.create_session),
    SeeSession(R.string.see_session),
    AddExercise(R.string.add_exercise),
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
                navController = navController
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
                onIsNavigationBarUpChange = onIsNavigationBarUpChange,
                onCanNavigateBackChange = onCanNavigateBackChange,
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
                navController = navController
            )
        }
    }
}