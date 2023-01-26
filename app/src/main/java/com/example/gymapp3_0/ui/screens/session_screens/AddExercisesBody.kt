package com.example.gymapp3_0.ui.screens.session_screens

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gymapp3_0.ui.screens.session_screens.components.ExerciseContent
import com.example.gymapp3_0.ui.viewModels.ExerciseViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun AddExerciseBody(
    viewModel: ExerciseViewModel = hiltViewModel(),
    navigateBackToCreateSession: () -> Unit,
    navigateToCreateExercise: () -> Unit,
) {

    val exercises by viewModel.exercises.collectAsState(
        initial = emptyList()
    )

    Scaffold(
        content = { padding ->


            ExerciseContent(
                padding = padding,
                exercises = exercises,
                deleteExercise = { exercise ->
                    viewModel.deleteExercise(exercise)
                },
                navigateToCreateExercise = navigateToCreateExercise
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