package com.example.gymapp3_0.ui.screens.session_screens

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gymapp3_0.ui.screens.components.AddExerciseAlertDialog
import com.example.gymapp3_0.ui.screens.components.ExerciseContent
import com.example.gymapp3_0.ui.screens.components.TopBar
import com.example.gymapp3_0.ui.viewModels.ExerciseViewModel
import com.example.gymapp3_0.ui.viewModels.SessionViewModel

val MuscleList = listOf(
    "Pectoraux",
    "Triceps",
    "Biceps",
    "Epaules",
    "Dos",
    "Abdominaux",
    "Jambes"
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddExerciseBody(

    @StringRes screenTitle: Int,
    navController: NavController,
    navigateToSettings: () -> Unit,
    sessionId: Int,
    sessionViewModel: SessionViewModel = hiltViewModel(),
    exerciseViewModel: ExerciseViewModel = hiltViewModel()
) {

    LaunchedEffect(Unit) {
        sessionViewModel.getSession(sessionId)
    }

    val exercises by exerciseViewModel.exercises.collectAsState(
        initial = emptyList()
    )

    val session = sessionViewModel.session

    val sessionExerciseList = session.exerciseList.map { it }.toMutableList()

    Scaffold(
        topBar = {
            TopBar(
                canNavigateBack = true,
                navigateBack = {
                    navController.navigateUp()
                    for (exercise in exercises) {
                        if (exercise.isSelected) {
                            exercise.isSelected = false
                            exerciseViewModel.updateExercise(exercise)
                        }
                    }
                },
                navigateToSettings = navigateToSettings
            )
        },
        content = { padding ->
            ExerciseContent(
                padding = padding,
                exercises = exercises,
                deleteExercise = { exercise ->
                    exerciseViewModel.deleteExercise(exercise)
                },
                session = session
            )

            AddExerciseAlertDialog(
                openDialog = exerciseViewModel.openDialog,
                closeDialog = { exerciseViewModel.closeDialog() },
                addExercise = { exercise ->
                    exerciseViewModel.addExercise(exercise)
                })


        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    sessionExerciseList.clear()
                    for (exercise in exercises) {
                        if (exercise.isSelected) {
                            sessionExerciseList.add(exercise)
                            exercise.isSelected = false
                            exerciseViewModel.updateExercise(exercise)
                        }
                    }
                    session.exerciseList = sessionExerciseList.toList()
                    sessionViewModel.updateSession(session)

                    navController.navigateUp()
                },
            ) {
                Icon(
                    Icons.Filled.Check,
                    contentDescription = "Back to Create Session"
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End
    )
}