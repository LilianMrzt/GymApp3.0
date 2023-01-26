package com.example.gymapp3_0.ui.screens.session_screens.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.gymapp3_0.domain.models.ExerciseModel
import com.example.gymapp3_0.domain.repository.Exercises

@Composable
@ExperimentalMaterialApi
fun ExerciseContent(
    padding: PaddingValues,
    exercises: Exercises,
    deleteExercise: (session: ExerciseModel) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        items(
            items = exercises
        ) { exercise ->
            ExerciseCard(
                exercise = exercise,
                deleteExercise = {
                    deleteExercise(exercise)
                },
            )
        }
    }
}