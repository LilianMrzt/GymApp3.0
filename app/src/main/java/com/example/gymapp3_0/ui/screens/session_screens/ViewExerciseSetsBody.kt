package com.example.gymapp3_0.ui.screens.session_screens

import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gymapp3_0.ui.screens.components.AddSetAlertDialog
import com.example.gymapp3_0.ui.screens.components.SetContentCard2
import com.example.gymapp3_0.ui.screens.components.SetViewHeader
import com.example.gymapp3_0.ui.screens.components.TopBar
import com.example.gymapp3_0.ui.viewModels.ExerciseViewModel
import com.example.gymapp3_0.ui.viewModels.SetsViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun ViewExerciseSetsBody(
    exerciseViewModel: ExerciseViewModel = hiltViewModel(),
    setsViewModel: SetsViewModel = hiltViewModel(),
    exerciseId: Int,
    @StringRes screenTitle: Int,
    navController: NavController
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
        content = { paddingValues ->
            LazyColumn(
                state = rememberLazyListState(),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                stickyHeader {
                    SetViewHeader(exercise = exerciseViewModel.exercise)
                    //Text(text = exerciseViewModel.exercise.id.toString())
                }

                items(
                    items = sets
                ) { set ->
                    SetContentCard2(
                        set = set,
                        updateWeight = { weight ->
                            setsViewModel.updateWeight(weight)
                        },
                        updateReps = { reps ->
                            setsViewModel.updateReps(reps)
                        },
                        updateRestTime = { restTime ->
                            setsViewModel.updateRest(restTime)
                        },
                        updateSet = { set2 ->
                            setsViewModel.updateSet(set2)
                        }
                    )
                }
                item {
                    Button(onClick = {
                        //openDialog = true
                        setsViewModel.openDialog()
                    }) {
                        Text(text = "Add Set")
                    }
                }

                item {
                    Button(onClick = {
                        navController.navigateUp()
                    }) {
                        Text(text = "Back")
                    }
                }
            }

            AddSetAlertDialog(
                openDialog = setsViewModel.openDialog,
                closeDialog = {
                    setsViewModel.closeDialog()
                },
                exerciseModel = exerciseViewModel.exercise
            )
            /*
            AddSetAlertDialog(
                openDialog = setsViewModel.openDialog,
                closeDialog = {
                    setsViewModel.closeDialog()
                },
                addSet = { set ->
                    setsViewModel.addSet(set)
                }
            )
            
             */
        }
    )


}