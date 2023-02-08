package com.example.gymapp3_0.ui.screens.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gymapp3_0.domain.models.ExerciseModel
import com.example.gymapp3_0.domain.models.SessionModel
import com.example.gymapp3_0.domain.repository.Exercises
import com.example.gymapp3_0.ui.viewModels.ExerciseViewModel
import com.example.gymapp3_0.ui.viewModels.SessionViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExerciseContent(
    padding: PaddingValues,
    exercises: Exercises,
    deleteExercise: (exercise: ExerciseModel) -> Unit,
    session: SessionModel,
    exerciseViewModel: ExerciseViewModel = hiltViewModel(),
    sessionViewModel: SessionViewModel = hiltViewModel()
) {
    //When exercise is deleted
    val sessions by sessionViewModel.sessions.collectAsState(
        initial = emptyList()
    )



    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val grouped = exercises.groupBy { it.muscle }
        stickyHeader {
            AddExerciseHeader()
        }

        grouped.forEach(){ (muscle, muscleExercise)->

            stickyHeader {
                Text(text = muscle,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier
                        .background(color = MaterialTheme.colorScheme.background)
                        .padding(
                            top = 16.dp,
                            bottom = 5.dp,
                            start = 16.dp,
                            end = 16.dp
                        )
                        .fillMaxWidth()
                )
            }

            items(
                items = muscleExercise
            ) { exercise ->
                //val copyExercise = exercise.copy()

                ExerciseCardForSessionCreation(
                    exercise = exercise,
                    deleteExercise = {
                        deleteExercise(exercise)
                    },
                )
            }
        }

        item {
            Spacer(modifier = Modifier.height(80.dp))
        }
    }
}