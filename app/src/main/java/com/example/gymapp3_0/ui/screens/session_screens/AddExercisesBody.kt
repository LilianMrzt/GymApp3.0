package com.example.gymapp3_0.ui.screens.session_screens

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gymapp3_0.domain.models.ExerciseModel
import com.example.gymapp3_0.ui.navigation.AddSessionRoutes
import com.example.gymapp3_0.ui.screens.components.ExerciseContent
import com.example.gymapp3_0.ui.screens.components.TopBar
import com.example.gymapp3_0.ui.viewModels.ExerciseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddExerciseBody(
    viewModel: ExerciseViewModel = hiltViewModel(),
    navigateBackToCreateSession: () -> Unit,
    temporaryList: MutableList<ExerciseModel>,
    @StringRes screenTitle: Int,
    navController: NavController,
    navigateToCreateExercise: () -> Unit,
) {

    val exercises by viewModel.exercises.collectAsState(
        initial = emptyList()
    )

    Scaffold(
        topBar = {
            TopBar(canNavigateBack = true) {
                navController.navigate(AddSessionRoutes.CreateSession.name)
            }
        },
        content = { padding ->
            ExerciseContent(
                padding = padding,
                exercises = exercises,
                temporaryList = temporaryList,
                navigateToCreateExercise = navigateToCreateExercise,
                deleteExercise = { exercise ->
                    viewModel.deleteExercise(exercise)
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateBackToCreateSession,
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