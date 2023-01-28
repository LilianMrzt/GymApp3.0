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

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ExercisesMainBody(
    viewModel: ExerciseViewModel = hiltViewModel(),
    navigateToCreateExercise: () -> Unit,
) {

    val exercises by viewModel.exercises.collectAsState(
        initial = emptyList()
    )

    Scaffold(
        content = { padding ->
            ExerciseListContent(
                padding = padding,
                exercises = exercises,
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