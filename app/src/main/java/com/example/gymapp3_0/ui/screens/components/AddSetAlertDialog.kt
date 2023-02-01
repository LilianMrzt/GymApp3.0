package com.example.gymapp3_0.ui.screens.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gymapp3_0.R
import com.example.gymapp3_0.core.Constants.Companion.NO_VALUE
import com.example.gymapp3_0.domain.models.ExerciseModel
import com.example.gymapp3_0.domain.models.SetModel
import com.example.gymapp3_0.ui.viewModels.SetsViewModel
import kotlinx.coroutines.job

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddSetAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    setsViewModel: SetsViewModel = hiltViewModel(),
    exerciseModel: ExerciseModel,
    exerciseId: Int,
) {


    if (openDialog) {
        var weight by remember { mutableStateOf(NO_VALUE) }
        var reps by remember { mutableStateOf(NO_VALUE) }
        var restTime by remember { mutableStateOf(NO_VALUE) }
        val focusRequester = FocusRequester()

        AlertDialog(
            onDismissRequest = closeDialog,
            title = {
                Text(text = stringResource(R.string.warning))
            },
            text = {
                Column {
                    TextField(
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        value = weight,
                        onValueChange = { weight = it },
                        placeholder = {
                            Text(
                                text = "Weight"
                            )
                        },
                        modifier = Modifier.focusRequester(focusRequester)
                    )
                    LaunchedEffect(Unit) {
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        value = reps,
                        onValueChange = { reps = it },
                        placeholder = {
                            Text(
                                text = "Repetitions"
                            )
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        value = restTime,
                        onValueChange = { restTime = it },
                        placeholder = {
                            Text(
                                text = "Rest Time"
                            )
                        }
                    )
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        closeDialog()
                        val set =
                            SetModel(
                                id = 0,
                                weight = weight,
                                reps = reps,
                                restTime = restTime,
                                exerciseId = exerciseId,
                            )
                        setsViewModel.addSet(set)
                    },
                ) {
                    Text(stringResource(R.string.delete))
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialog
                ) {
                    Text(stringResource(R.string.cancel))
                }
            }
        )
    }
}