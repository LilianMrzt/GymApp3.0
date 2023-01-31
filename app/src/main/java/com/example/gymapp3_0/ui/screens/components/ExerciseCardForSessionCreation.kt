package com.example.gymapp3_0.ui.screens.components

import android.annotation.SuppressLint
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gymapp3_0.R
import com.example.gymapp3_0.domain.models.ExerciseModel
import com.example.gymapp3_0.ui.viewModels.ExerciseViewModel
import com.example.gymapp3_0.ui.viewModels.SessionViewModel

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExerciseCard(
    exercise: ExerciseModel,
    ExerciseViewModel: ExerciseViewModel = hiltViewModel(),
    sessionViewModel: SessionViewModel = hiltViewModel(),
) {
    val isSelected = remember { mutableStateOf(exercise.isSelected) }
    var popupControl by remember { mutableStateOf(false) }
    var deleteClicked by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    var exo2 = ExerciseModel(exercise.id, "", "", false, mutableListOf())

    ElevatedCard(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 5.dp, bottom = 5.dp),
        onClick = {
            val exo = exercise.copy() // This way works
            isSelected.value = !isSelected.value
            exo.isSelected = isSelected.value
            //exercise.isSelected = isSelected.value
            ExerciseViewModel.updateExercise(exo)
        }
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

            Spacer(modifier = Modifier.weight(1f))

            if (exercise.isSelected) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = "selected"
                )
            }

            IconButton(
                onClick = {
                    deleteClicked = true
                    exo2 = exercise.copy()
                },
                modifier = Modifier
                    .size(30.dp)
                    .padding(0.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "",
                )
            }

            if (deleteClicked) {
                AlertDialog(
                    onDismissRequest = {
                        deleteClicked = false
                    },
                    title = {
                        Text(text = stringResource(R.string.warning))
                    },
                    text = {
                        Text(text = stringResource(R.string.delete_exercise_confirmation))
                    },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                deleteClicked = false
                            },
                            interactionSource = interactionSource
                        ) {
                            Text(stringResource(R.string.delete))
                            if (isPressed) {
                                ExerciseViewModel.deleteExercise(exo2)
                            }
                        }
                    },
                    dismissButton = {
                        TextButton(
                            onClick = {
                                deleteClicked = false
                            }
                        ) {
                            Text(stringResource(R.string.cancel))
                        }
                    }
                )
            }
        }
    }
}