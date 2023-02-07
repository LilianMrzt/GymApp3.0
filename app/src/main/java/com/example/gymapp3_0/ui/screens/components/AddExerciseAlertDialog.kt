package com.example.gymapp3_0.ui.screens.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.example.gymapp3_0.R
import com.example.gymapp3_0.core.Constants
import com.example.gymapp3_0.domain.models.ExerciseModel
import com.example.gymapp3_0.ui.screens.session_screens.MuscleList
import kotlinx.coroutines.job

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddExerciseAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addExercise: (exercise: ExerciseModel) -> Unit,
) {
    if (openDialog) {
        var name by remember { mutableStateOf(Constants.NO_VALUE) }
        var muscle by remember { mutableStateOf(Constants.NO_VALUE) }
        val focusRequester = FocusRequester()
        val context = LocalContext.current

        //DropDownMenu
        var expanded by remember { mutableStateOf(false) }
        var muscleSelected by remember { mutableStateOf(false) }
        var textFieldSize by remember { mutableStateOf(Size.Zero) }
        val icon = if (expanded) {
            Icons.Filled.KeyboardArrowUp
        } else {
            Icons.Filled.KeyboardArrowDown
        }

        AlertDialog(
            onDismissRequest = closeDialog,
            title = {
                Text(text = stringResource(R.string.add_exercise))
            },
            text = {
                Column {
                    TextField(
                        value = name,
                        onValueChange = { name = it },
                        placeholder = {
                            Text(
                                text = stringResource(R.string.exercise_name)
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .focusRequester(focusRequester),
                        singleLine = true,
                        shape = RoundedCornerShape(Constants.ROUNDED_CORNER),
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = MaterialTheme.colorScheme.onPrimary,
                            disabledTextColor = MaterialTheme.colorScheme.secondary,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent
                        )
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    LaunchedEffect(Unit) {
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,

                        ) {

                        Text(
                            text = stringResource(R.string.exercise_muscle),
                            modifier = Modifier.padding(bottom = 5.dp, top = 16.dp)
                        )

                        ElevatedCard(
                            modifier = Modifier
                                .fillMaxWidth()
                                .onGloballyPositioned { coordinates ->
                                    textFieldSize = coordinates.size.toSize()
                                },
                            onClick = { expanded = !expanded },
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.surfaceVariant,
                            ),
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(16.dp)
                            ) {
                                if (!muscleSelected) {
                                    Text(
                                        text = stringResource(R.string.select_muscle),
                                        style = MaterialTheme.typography.bodyLarge
                                    )
                                } else {
                                    Text(
                                        text = muscle,
                                        style = MaterialTheme.typography.bodyLarge
                                    )
                                }

                                Spacer(modifier = Modifier.weight(1f))

                                Icon(
                                    icon, ""
                                )
                            }
                        }

                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                            modifier = Modifier
                                .width(with(LocalDensity.current) {
                                    textFieldSize.width.toDp()
                                })
                                .background(MaterialTheme.colorScheme.surfaceVariant),
                        ) {
                            MuscleList.forEach { label ->
                                DropdownMenuItem(
                                    onClick = {
                                        muscle = label
                                        expanded = false
                                        muscleSelected = true
                                    },
                                    text = { Text(text = label) },
                                    modifier = Modifier
                                )
                            }
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        if (name != Constants.NO_VALUE && muscle != Constants.NO_VALUE) {
                            val exercise = ExerciseModel(
                                0, name, muscle, false, mutableListOf()
                            )
                            addExercise(exercise)
                            closeDialog()

                        } else {
                            Toast.makeText(
                                context,
                                R.string.complete_every_field,
                                Toast.LENGTH_LONG
                            )
                                .show()
                        }
                    },
                ) {
                    Text(stringResource(R.string.add))
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
