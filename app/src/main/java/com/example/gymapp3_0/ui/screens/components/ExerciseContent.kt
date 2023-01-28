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
import com.example.gymapp3_0.domain.repository.Exercises

@Composable
@ExperimentalMaterialApi
fun ExerciseContent(
    padding: PaddingValues,
    exercises: Exercises,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(
            items = exercises
        ) { exercise ->
            ExerciseCard(
                exercise = exercise,
            )
        }
    }
}