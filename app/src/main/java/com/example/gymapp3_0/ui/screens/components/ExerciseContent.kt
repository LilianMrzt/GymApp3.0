package com.example.gymapp3_0.ui.screens.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.gymapp3_0.domain.models.ExerciseModel
import com.example.gymapp3_0.domain.repository.Exercises

@Composable
@ExperimentalMaterialApi
fun ExerciseContent(
    padding: PaddingValues,
    exercises: Exercises,
    temporaryList: MutableList<ExerciseModel>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(
            items = exercises
        ) { item ->
            val copyExercise = item.copy()

            ExerciseCard(
                exercise = item,
            )

            if (!temporaryList.contains(copyExercise) && copyExercise.isSelected) {
                temporaryList.add(copyExercise)
            } else if (temporaryList.contains(copyExercise) && !copyExercise.isSelected) {
                temporaryList.remove(copyExercise)
            }
        }
    }
}