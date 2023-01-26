package com.example.gymapp3_0.ui.screens.session_screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gymapp3_0.R
import com.example.gymapp3_0.ui.screens.session_screens.components.AddExerciseCard
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
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AddExerciseCard(
                    navigateToAddExercises = navigateToCreateExercise,
                    label = R.string.create_exercise
                )

                Divider(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 32.dp, end = 32.dp),
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.onBackground
                )

                Spacer(modifier = Modifier.height(5.dp))

                ExerciseContent(
                    padding = padding,
                    exercises = exercises,
                    deleteExercise = { exercise ->
                        viewModel.deleteExercise(exercise)
                    },
                )
            }

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