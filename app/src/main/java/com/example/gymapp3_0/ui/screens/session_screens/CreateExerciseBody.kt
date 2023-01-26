package com.example.gymapp3_0.ui.screens.session_screens

import android.annotation.SuppressLint
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.gymapp3_0.R
import com.example.gymapp3_0.core.Constants
import com.example.gymapp3_0.domain.models.ExerciseModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateExerciseBody(
    modifier: Modifier,
    addExercise: (exercise: ExerciseModel) -> Unit,
    navigateBackToAddExercise: () -> Unit,
) {

    var name by remember { mutableStateOf(Constants.NO_VALUE) }
    var muscle by remember { mutableStateOf(Constants.NO_VALUE) }

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Scaffold(
        floatingActionButton = {
            if (name != Constants.NO_VALUE && muscle != Constants.NO_VALUE) {
                FloatingActionButton(
                    onClick = navigateBackToAddExercise,

                    interactionSource = interactionSource
                ) {
                    Icon(
                        Icons.Filled.Check,
                        contentDescription = "Create Exercise"
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 10.dp,
                    bottom = 10.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                TextField(
                    value = name,
                    onValueChange = { name = it },
                    placeholder = {
                        Text(
                            //text = Constants.SESSION_NAME
                            text = stringResource(R.string.exercise_name)
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
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
            }

            item {
                TextField(
                    value = muscle,
                    onValueChange = { muscle = it },
                    placeholder = {
                        Text(
                            text = stringResource(R.string.exercise_muscle)
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth(),
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
            }



            if (isPressed) {
                val exercise = ExerciseModel(0, name, muscle)
                addExercise(exercise)
            }
        }
    }
}