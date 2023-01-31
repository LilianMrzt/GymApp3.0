package com.example.gymapp3_0.ui.screens.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
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
    var title by remember { mutableStateOf(NO_VALUE) }
    var author by remember { mutableStateOf(NO_VALUE) }
    val focusRequester = FocusRequester()

    if (openDialog) {
        AlertDialog(
            onDismissRequest = closeDialog,
            title = {
                Text(text = stringResource(R.string.warning))
            },
            text = {
                Column {
                    TextField(
                        value = title,
                        onValueChange = { title = it },
                        placeholder = {
                            Text(
                                text = "BOOK_TITLE"
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
                        value = author,
                        onValueChange = { author = it },
                        placeholder = {
                            Text(
                                text = "AUTHOR"
                            )
                        }
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    TextField(
                        value = author,
                        onValueChange = { author = it },
                        placeholder = {
                            Text(
                                text = "AUTHOR"
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
                                title,
                                author,
                                author,
                                exerciseId,
                            )
                        /*
                        val setList = exerciseModel.setList.map { it }.toMutableList()
                        setList.add(set)
                        val exercise = ExerciseModel(
                            id = exerciseModel.id,
                            name = exerciseModel.name,
                            setList = setList
                        )
                        //exerciseViewModel.updateExercise(exercise)

                         */
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
