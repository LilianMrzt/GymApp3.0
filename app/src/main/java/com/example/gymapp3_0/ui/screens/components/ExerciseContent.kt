package com.example.gymapp3_0.ui.screens.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
        stickyHeader {
            AddExerciseHeader()
        }

        items(
            items = exercises
        ) { exercise ->
            //val copyExercise = exercise.copy()

            ExerciseCardForSessionCreation(
                exercise = exercise,
                deleteExercise = {
                    deleteExercise(exercise)
                    /*
                    sessions.forEach { session ->
                        if (session.exerciseList.contains(exercise)) {
                            val sessionExerciseList =
                                session.exerciseList.map { it }.toMutableList()
                            sessionExerciseList.clear()
                            session.exerciseList = sessionExerciseList.toList()
                            sessionViewModel.updateSession(session)
                        }
                    }

                     */
                },
            )
        }
    }
}