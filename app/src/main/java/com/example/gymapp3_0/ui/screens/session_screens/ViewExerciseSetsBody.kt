package com.example.gymapp3_0.ui.screens.session_screens

import androidx.annotation.StringRes
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gymapp3_0.domain.models.SetModel
import com.example.gymapp3_0.ui.screens.components.AddSetAlertDialog
import com.example.gymapp3_0.ui.screens.components.SetContent
import com.example.gymapp3_0.ui.screens.components.TopBar
import com.example.gymapp3_0.ui.viewModels.ExerciseViewModel
import com.example.gymapp3_0.ui.viewModels.SetsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewExerciseSetsBody(
    exerciseViewModel: ExerciseViewModel = hiltViewModel(),
    setsViewModel: SetsViewModel = hiltViewModel(),
    exerciseId: Int,
    @StringRes screenTitle: Int,
    navController: NavController,
    navigateToUpdateSetScreen: (setId: Int) -> Unit,
    temporarySetList: MutableList<SetModel>,
) {
    LaunchedEffect(Unit) {
        exerciseViewModel.getExercise(exerciseId)
    }

    val sets by setsViewModel.sets.collectAsState(
        initial = emptyList()
    )

    Scaffold(
        topBar = {
            TopBar(canNavigateBack = true) {
                navController.navigateUp()
            }
        },
        content = { padding ->
            SetContent(
                padding = padding,
                sets = sets,
                navigateToUpdateSetScreen = navigateToUpdateSetScreen,
                navController = navController,
                exerciseId = exerciseId,
                exercise = exerciseViewModel.exercise,
                deleteSet = { set ->
                    setsViewModel.deleteSet(set)
                }
            )

            AddSetAlertDialog(
                openDialog = setsViewModel.openDialog,
                closeDialog = {
                    setsViewModel.closeDialog()
                },
                exercise = exerciseViewModel.exercise,
                exerciseId = exerciseId,
                temporarySetList = temporarySetList,
            ) { set ->
                setsViewModel.addSet(set)
            }
        }
    )
}