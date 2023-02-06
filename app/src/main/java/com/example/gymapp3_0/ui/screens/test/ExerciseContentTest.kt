package com.example.gymapp3_0.ui.screens.test

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.gymapp3_0.domain.models.ExerciseModel
import com.example.gymapp3_0.domain.repository.Exercises

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExerciseContentTest(
    padding: PaddingValues,
    exercises: Exercises,
    temporaryList: MutableList<ExerciseModel>,
    navigateToCreateExercise: () -> Unit,
    deleteExercise: (exercise: ExerciseModel) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        stickyHeader {
            AddExerciseHeaderTest(
                navigateToCreateExercise
            )
        }

        items(
            items = exercises
        ) { exercise ->
            //val copyExercise = exercise.copy()

            ExerciseCardTest(
                exercise = exercise,
                deleteExercise = {
                    deleteExercise(exercise)
                },
                temporaryList = temporaryList
            )
        }
    }
}