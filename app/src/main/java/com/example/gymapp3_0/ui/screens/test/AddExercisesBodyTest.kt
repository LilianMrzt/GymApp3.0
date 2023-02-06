package com.example.gymapp3_0.ui.screens.test

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gymapp3_0.domain.models.ExerciseModel
import com.example.gymapp3_0.ui.screens.components.TopBar
import com.example.gymapp3_0.ui.viewModels.ExerciseViewModel
import com.example.gymapp3_0.ui.viewModels.SessionViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddExerciseBodyTest(

    navigateBackToCreateSession: () -> Unit,
    temporaryList: MutableList<ExerciseModel>,
    @StringRes screenTitle: Int,
    navController: NavController,
    navigateToCreateExercise: () -> Unit,
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

    /*
    exercises.forEach { exercise ->
        if (sessionExerciseList.contains(exercise)) {
            exercise.isSelected = true
            exerciseViewModel.updateExercise(exercise)
        } else {
            exercise.isSelected = false
            exerciseViewModel.updateExercise(exercise)
        }
    }

     */

    Scaffold(
        topBar = {
            TopBar(
                canNavigateBack = true,
                navigateBack = {
                    //navController.navigate(AddSessionRoutes.CreateSession.name)
                    navController.navigateUp()
                },
                navigateToSettings = navigateToSettings
            )
        },
        content = { padding ->
            ExerciseContentTest(
                padding = padding,
                exercises = exercises,
                temporaryList = sessionExerciseList,
                navigateToCreateExercise = navigateToCreateExercise,
                deleteExercise = { exercise ->
                    exerciseViewModel.deleteExercise(exercise)
                }
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
                    session.exerciseList = sessionExerciseList.map { it }
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