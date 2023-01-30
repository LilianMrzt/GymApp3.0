package com.example.gymapp3_0.ui.screens.session_screens

import androidx.annotation.StringRes
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gymapp3_0.ui.screens.components.SetContentCard
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
    navController: NavController
) {
    LaunchedEffect(Unit) {
        exerciseViewModel.getExercise(exerciseId)
    }
    Scaffold(
        topBar = {
            TopBar(title = screenTitle, canNavigateBack = true) {
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
                item {
                    Text(text = exerciseViewModel.exercise.name)
                    Text(text = exerciseViewModel.exercise.id.toString())
                }

                items(
                    items = exerciseViewModel.exercise.setList
                ) { sets ->
                    SetContentCard(sets)
                }

                item {
                    Button(onClick = {
                        exerciseViewModel.exercise.setList.forEach {
                            setsViewModel.updateSet(it)
                        }
                        navController.navigateUp()
                    }) {

                    }
                }
            }

        }
    )


}