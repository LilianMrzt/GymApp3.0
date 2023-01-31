package com.example.gymapp3_0.ui.screens.components.test

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gymapp3_0.ui.screens.components.TopBar
import com.example.gymapp3_0.ui.viewModels.SetsViewModel

@Composable
fun UpdateSetScreen(
    setsViewModel: SetsViewModel = hiltViewModel(),
    setId: Int,
    navigateBack: () -> Unit,
    navController: NavController
) {
    LaunchedEffect(Unit) {
        setsViewModel.getSet(setId)
    }
    Scaffold(
        topBar = {
            TopBar(canNavigateBack = true) {
                navController.navigateUp()
            }
        },
        content = { padding ->
            UpdateSetContent(
                padding = padding,
                set = setsViewModel.set,
                updateWeight = { weight ->
                    setsViewModel.updateWeight(weight)
                },
                updateReps = { reps ->
                    setsViewModel.updateReps(reps)
                },
                updateRestTime = { rest ->
                    setsViewModel.updateRest(rest)
                },
                updateSet = { set ->
                    setsViewModel.updateSet(set)
                },
                navigateBack = navigateBack
            )
        }
    )
}