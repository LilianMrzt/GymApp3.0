package com.example.gymapp3_0.ui.screens.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ModeEditOutline
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gymapp3_0.domain.models.ExerciseModel
import com.example.gymapp3_0.domain.repository.Exercises
import com.example.gymapp3_0.ui.viewModels.ExerciseViewModel

@Composable
fun ViewSessionHeader(
    @StringRes title: Int,
    navigateToAddExercise: () -> Unit,
    exercises: Exercises,
    sessionList: List<ExerciseModel>,
    exerciseViewModel: ExerciseViewModel = hiltViewModel()
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        shape = RectangleShape
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 0.dp, bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Spacer(modifier = Modifier.width(24.dp))

                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = stringResource(id = title),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.weight(1f))

                IconButton(
                    onClick = {
                        for (exercise in exercises) {
                            if (sessionList.contains(exercise)) {
                                exercise.isSelected = true
                                exerciseViewModel.updateExercise(exercise)
                            }
                        }
                        navigateToAddExercise()
                    },
                    modifier = Modifier
                        .size(30.dp)
                        .padding(0.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ModeEditOutline,
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(0.dp)
                    )
                }
            }

            Divider(
                Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 64.dp,
                        end = 64.dp,
                        top = 16.dp,
                        bottom = 0.dp
                    )
            )
        }
    }
}