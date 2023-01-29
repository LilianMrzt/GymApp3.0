package com.example.gymapp3_0.ui.navigation

import androidx.annotation.StringRes
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.gymapp3_0.R
import com.example.gymapp3_0.ui.screens.Screen
import com.example.gymapp3_0.ui.screens.create_exercise_list_screens.ExercisesMainBody
import com.example.gymapp3_0.ui.screens.session_screens.CreateExerciseBody
import com.example.gymapp3_0.ui.viewModels.ExerciseViewModel

enum class AddExerciseRoutes(@StringRes val title: Int) {
    StartCreateExercise(R.string.main_exercise_screen),
    CreateExercise(R.string.create_exercise)
}

fun NavGraphBuilder.exerciseListNavigation(
    navController: NavHostController,
    exerciseViewModel: ExerciseViewModel,
    @StringRes screenTitle: Int,
    onIsNavigationBarUpChange: (Boolean) -> Unit,
) {
    navigation(
        startDestination = AddExerciseRoutes.StartCreateExercise.name,
        route = Screen.Exercises.route
    ) {
        //MainSessionBody
        composable(
            route = AddExerciseRoutes.StartCreateExercise.name
        ) {
            onIsNavigationBarUpChange(true)
            ExercisesMainBody(
                navigateToCreateExercise = {
                    navController.navigate(AddExerciseRoutes.CreateExercise.name)
                },
                screenTitle = screenTitle,
                navController = navController
            )
        }
    }

    //CreateExercise
    composable(route = AddExerciseRoutes.CreateExercise.name) {
        onIsNavigationBarUpChange(false)
        CreateExerciseBody(
            addExercise = { exercise ->
                exerciseViewModel.addExercise(exercise)
            },
            navigateBackToAddExercise = {
                navController.navigate(AddExerciseRoutes.StartCreateExercise.name)
            },
            screenTitle = screenTitle,
            navController = navController
        )
    }
}