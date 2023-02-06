package com.example.gymapp3_0.ui.navigation

import androidx.annotation.StringRes
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType.Companion.IntType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.gymapp3_0.R
import com.example.gymapp3_0.core.Constants.Companion.EXERCISE_ID
import com.example.gymapp3_0.core.Constants.Companion.SESSION_ID
import com.example.gymapp3_0.core.Constants.Companion.SET_ID
import com.example.gymapp3_0.ui.screens.Screen
import com.example.gymapp3_0.ui.screens.session_screens.AddExerciseBody
import com.example.gymapp3_0.ui.screens.session_screens.SessionsMainBody
import com.example.gymapp3_0.ui.screens.session_screens.Settings
import com.example.gymapp3_0.ui.screens.session_screens.UpdateSetScreen
import com.example.gymapp3_0.ui.screens.session_screens.ViewExerciseSetsBody
import com.example.gymapp3_0.ui.screens.session_screens.ViewSessionBody
import com.example.gymapp3_0.ui.viewModels.ExerciseViewModel
import com.example.gymapp3_0.ui.viewModels.SessionViewModel
import com.example.gymapp3_0.ui.viewModels.SetsViewModel

enum class AddSessionRoutes(@StringRes val title: Int) {
    Start(R.string.main_session_screen),
    SeeSession(R.string.see_session),
    SeeExerciseSets(R.string.see_exercise_sets),
    UpdateSet(R.string.update_set),
    Settings(R.string.settings),
    AddExerciseTest(R.string.test)
}

fun NavGraphBuilder.sessionListNavigation(
    navController: NavHostController,
    sessionViewModel: SessionViewModel,
    exerciseViewModel: ExerciseViewModel,
    setsViewModel: SetsViewModel,
    onCanNavigateBackChange: (Boolean) -> Unit,
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
            SessionsMainBody(
                navigateToViewSession = { sessionId ->
                    navController.navigate("${AddSessionRoutes.SeeSession.name}/${sessionId}")
                },
                temporaryList = sessionViewModel.temporaryList,
                screenTitle = screenTitle,
                navigateToSettings = {
                    navController.navigate(AddSessionRoutes.Settings.name)
                }
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
            ViewSessionBody(
                sessionId = sessionId,
                screenTitle = screenTitle,
                navController = navController,
                navigateToViewExerciseContent = { exerciseId ->
                    navController.navigate("${AddSessionRoutes.SeeExerciseSets.name}/${exerciseId}")
                },
                navigateToSettings = {
                    navController.navigate(AddSessionRoutes.Settings.name)
                },
                navigateToAddExercise = {
                    navController.navigate("${AddSessionRoutes.AddExerciseTest.name}/${sessionId}")
                }

            )
        }

        //SeeExerciseSets
        composable(
            route = "${AddSessionRoutes.SeeExerciseSets.name}/{${EXERCISE_ID}}",
            arguments = listOf(
                navArgument(EXERCISE_ID) {
                    type = IntType
                },
            )
        ) { backStackEntry ->
            val exerciseId = backStackEntry.arguments?.getInt(EXERCISE_ID) ?: 0
            ViewExerciseSetsBody(
                exerciseId = exerciseId,
                screenTitle = screenTitle,
                navController = navController,
                navigateToUpdateSetScreen = { setId ->
                    navController.navigate("${AddSessionRoutes.UpdateSet.name}/${setId}")
                },
                temporarySetList = exerciseViewModel.temporarySetList,
                navigateToSettings = {
                    navController.navigate(AddSessionRoutes.Settings.name)
                }
            )
        }

        //UpdateSet
        composable(
            route = "${AddSessionRoutes.UpdateSet.name}/{${SET_ID}}",
            arguments = listOf(
                navArgument(SET_ID) {
                    type = IntType
                },
            )
        ) { backStackEntry ->
            val setId = backStackEntry.arguments?.getInt(SET_ID) ?: 0
            UpdateSetScreen(
                setId = setId,
                navigateBack = { navController.navigateUp() },
                navController = navController,
                navigateToSettings = {
                    navController.navigate(AddSessionRoutes.Settings.name)
                }
            )
        }


        //Settings
        composable(route = AddSessionRoutes.Settings.name) {
            Settings(
                navController = navController
            )
        }


        //Add Exercises Test
        composable(
            route = "${AddSessionRoutes.AddExerciseTest.name}/{${SESSION_ID}}",
            arguments = listOf(
                navArgument(SESSION_ID) {
                    type = IntType
                },
            )
        ) { backStackEntry ->
            val sessionId = backStackEntry.arguments?.getInt(SESSION_ID) ?: 0
            AddExerciseBody(
                screenTitle = screenTitle,
                navController = navController,
                navigateToSettings = {
                    navController.navigate(AddSessionRoutes.Settings.name)
                },
                sessionId = sessionId
            )
        }
    }
}