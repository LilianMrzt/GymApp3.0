package com.example.gymapp3_0.ui.screens.create_exercise_list_screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.gymapp3_0.R
import com.example.gymapp3_0.domain.repository.Exercises
import com.example.gymapp3_0.domain.repository.Sessions
import com.example.gymapp3_0.ui.screens.components.ExerciseCardForExerciseList

@Composable
@ExperimentalMaterialApi
fun ExerciseListContent(
    padding: PaddingValues,
    exercises: Exercises,
    sessions: Sessions
) {
    if (exercises.isEmpty()) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = stringResource(R.string.no_exercise_created))
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(
                items = exercises
            ) { exercise ->
                ExerciseCardForExerciseList(
                    exercise = exercise,
                    sessions = sessions
                )
            }
        }
    }

}