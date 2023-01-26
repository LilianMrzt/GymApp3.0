package com.example.gymapp3_0.ui.screens.session_screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gymapp3_0.domain.models.ExerciseModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExerciseCard(
    exercise: ExerciseModel,
    deleteExercise: () -> Unit,
) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 5.dp, bottom = 5.dp),
        shape = RoundedCornerShape(10.dp),
        onClick = { } //model.toggle()
    ) {
        Row(
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp,
                top = 10.dp,
                bottom = 10.dp
            ),
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
            /*

            Spacer(modifier = Modifier.weight(1f))


            if (exercise.isSelected.value) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "Selected",
                    Modifier.size(20.dp)
                )

            }

             */
        }
    }
}