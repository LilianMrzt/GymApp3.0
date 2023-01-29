package com.example.gymapp3_0.ui.screens.create_exercise_list_screens

import android.annotation.SuppressLint
import androidx.annotation.StringRes
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
import androidx.navigation.NavController
import com.example.gymapp3_0.ui.screens.components.ExerciseListContent
import com.example.gymapp3_0.ui.screens.components.TopBar
import com.example.gymapp3_0.ui.viewModels.ExerciseViewModel
import com.example.gymapp3_0.ui.viewModels.SessionViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ExercisesMainBody(
    exerciseViewModel: ExerciseViewModel = hiltViewModel(),
    sessionViewModel: SessionViewModel = hiltViewModel(),
    navigateToCreateExercise: () -> Unit,
    @StringRes screenTitle: Int,
    navController: NavController
) {

    val sessions by sessionViewModel.sessions.collectAsState(
        initial = emptyList()
    )

    val exercises by exerciseViewModel.exercises.collectAsState(
        initial = emptyList()
    )

    Scaffold(
        topBar = {
            TopBar(title = screenTitle, canNavigateBack = false) { }
        },
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