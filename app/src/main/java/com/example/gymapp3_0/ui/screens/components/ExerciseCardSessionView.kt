package com.example.gymapp3_0.ui.screens.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gymapp3_0.domain.models.ExerciseModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnrememberedMutableState")
@Composable
fun ExerciseCardForSessionView(
    exercise: ExerciseModel,
    navigateToViewExerciseContent: (exerciseId: Int) -> Unit,
) {
    ElevatedCard(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 5.dp),
        onClick = { navigateToViewExerciseContent(exercise.id) }
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
            ) {

                Text(
                    modifier = Modifier,
                    text = exercise.name,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    modifier = Modifier,
                    text = exercise.muscle
                )
            }
        }
    }
}