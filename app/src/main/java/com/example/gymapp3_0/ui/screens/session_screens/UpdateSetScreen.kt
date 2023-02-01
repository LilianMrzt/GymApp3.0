package com.example.gymapp3_0.ui.screens.session_screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gymapp3_0.ui.screens.components.TopBar
import com.example.gymapp3_0.ui.screens.components.UpdateSetContent
import com.example.gymapp3_0.ui.viewModels.SetsViewModel

@OptIn(ExperimentalMaterial3Api::class)
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
                setsViewModel.updateSet(setsViewModel.set)
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
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    setsViewModel.updateSet(setsViewModel.set)
                    navigateBack()

                },
            ) {
                Icon(
                    Icons.Filled.Check,
                    contentDescription = "Create Session"
                )
            }

        },
        floatingActionButtonPosition = FabPosition.End
    )
}