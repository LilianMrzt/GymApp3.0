package com.example.gymapp3_0.ui.screens.create_exercise_list_screens

import android.annotation.SuppressLint
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gymapp3_0.ui.viewModels.ExerciseViewModel
import com.example.gymapp3_0.ui.viewModels.SessionViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ExercisesMainBody(
    exerciseViewModel: ExerciseViewModel = hiltViewModel(),
    sessionViewModel: SessionViewModel = hiltViewModel(),
    navigateToCreateExercise: () -> Unit,
) {

    val sessions by sessionViewModel.sessions.collectAsState(
        initial = emptyList()
    )

    val exercises by exerciseViewModel.exercises.collectAsState(
        initial = emptyList()
    )

    Scaffold(
        content = { padding ->
            ExerciseListContent(
                padding = padding,
                exercises = exercises,
                sessions = sessions
            )
        },


        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToCreateExercise,
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Add Session")
            }
        },
    )
}