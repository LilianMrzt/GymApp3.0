package com.example.gymapp3_0.ui.screens.components.test

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gymapp3_0.domain.models.SetModel

@Composable
fun UpdateSetContent(
    padding: PaddingValues,
    set: SetModel,
    updateWeight: (weight: String) -> Unit,
    updateReps: (reps: String) -> Unit,
    updateRestTime: (rest: String) -> Unit,
    updateSet: (set: SetModel) -> Unit,
    navigateBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = set.weight,
            onValueChange = { weight ->
                updateWeight(weight)
            },
            placeholder = {
                Text(
                    text = "Weight"
                )
            }
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        TextField(
            value = set.reps,
            onValueChange = { reps ->
                updateReps(reps)
            },
            placeholder = {
                Text(
                    text = "Reps"
                )
            }
        )
        Spacer(
            modifier = Modifier.height(8.dp)
        )
        TextField(
            value = set.restTime,
            onValueChange = { restTime ->
                updateRestTime(restTime)
            },
            placeholder = {
                Text(
                    text = "Rest"
                )
            }
        )
        Button(
            onClick = {
                updateSet(set)
                navigateBack()
            }
        ) {
            Text(
                text = "update"
            )
        }
    }
}