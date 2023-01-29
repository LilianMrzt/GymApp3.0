package com.example.gymapp3_0.ui.screens.session_screens

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import androidx.navigation.NavController
import com.example.gymapp3_0.R
import com.example.gymapp3_0.core.Constants
import com.example.gymapp3_0.domain.models.ExerciseModel
import com.example.gymapp3_0.domain.models.SetModel
import com.example.gymapp3_0.ui.navigation.AddExerciseRoutes
import com.example.gymapp3_0.ui.screens.components.TopBar

val MuscleList = listOf(
    "Pectoraux",
    "Triceps",
    "Biceps",
    "Epaules",
    "Dos",
    "Abdominaux",
    "Jambes"
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateExerciseBody(
    addExercise: (exercise: ExerciseModel) -> Unit,
    navigateBackToAddExercise: () -> Unit,
    @StringRes screenTitle: Int,
    navController: NavController
) {

    var name by remember { mutableStateOf(Constants.NO_VALUE) }
    var muscle by remember { mutableStateOf(Constants.NO_VALUE) }

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    //DropDownMenu
    var expanded by remember { mutableStateOf(false) }
    var muscleSelected by remember { mutableStateOf(false) }
    var textFieldSize by remember { mutableStateOf(Size.Zero) }
    val icon = if (expanded) {
        Icons.Filled.KeyboardArrowUp
    } else {
        Icons.Filled.KeyboardArrowDown
    }

    Scaffold(
        topBar = {
            TopBar(title = screenTitle, canNavigateBack = true) {
                navController.navigate(AddExerciseRoutes.StartCreateExercise.name)
            }
        },
        content = { padding ->
            LazyColumn(
                Modifier
                    .fillMaxSize()
                    .padding(padding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
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
                            .padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 5.dp),
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
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(
                            start = 16.dp,
                            end = 16.dp,
                            top = 10.dp,
                            bottom = 5.dp
                        )
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
                            onClick = { expanded = !expanded }
                        ) {
                            Row(
                                modifier = Modifier
                                    .padding(16.dp)
                            ) {
                                if (!muscleSelected) {
                                    Text(
                                        text = stringResource(R.string.exercise_muscle)
                                    )
                                } else {
                                    Text(
                                        text = muscle
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
                            Modifier.width(with(LocalDensity.current) {
                                textFieldSize.width.toDp()
                            })
                        ) {
                            MuscleList.forEach() { label ->
                                androidx.compose.material.DropdownMenuItem(
                                    onClick = {
                                        muscle = label
                                        expanded = false
                                        muscleSelected = true
                                    },
                                ) {
                                    Text(text = label)
                                }
                            }
                        }
                    }
                }

                if (isPressed) {
                    val exercise = ExerciseModel(0, name, muscle, false, listOf<SetModel>())
                    addExercise(exercise)
                }
            }
        },
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
    )
}