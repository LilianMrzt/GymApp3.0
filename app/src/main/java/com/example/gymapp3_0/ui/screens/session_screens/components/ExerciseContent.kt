package com.example.gymapp3_0.ui.screens.session_screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gymapp3_0.R
import com.example.gymapp3_0.domain.repository.Exercises

@Composable
@ExperimentalMaterialApi
fun ExerciseContent(
    padding: PaddingValues,
    exercises: Exercises,
    navigateToCreateExercise: () -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {

            AddExerciseCard(
                navigateToAddExercises = navigateToCreateExercise,
                label = R.string.create_exercise
            )

            Divider(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 32.dp, end = 32.dp),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(5.dp))
        }
        items(
            items = exercises
        ) { exercise ->
            ExerciseCard(
                exercise = exercise,
            )
        }
    }
}