package com.example.gymapp3_0.ui.screens.session_screens

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.navigation.NavController
import com.example.gymapp3_0.R
import com.example.gymapp3_0.core.Constants
import com.example.gymapp3_0.core.Constants.Companion.NO_VALUE
import com.example.gymapp3_0.domain.models.ExerciseModel
import com.example.gymapp3_0.domain.models.SessionModel
import com.example.gymapp3_0.ui.navigation.AddSessionRoutes
import com.example.gymapp3_0.ui.screens.components.AddExerciseCard
import com.example.gymapp3_0.ui.screens.components.TopBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateSessionBody(
    modifier: Modifier,
    addSession: (session: SessionModel) -> Unit,
    navigateToMainSession: () -> Unit,
    navigateToAddExercises: () -> Unit,
    onCanNavigateBackChange: (Boolean) -> Unit,
    onIsNavigationBarUpChange: (Boolean) -> Unit,
    temporaryList: MutableList<ExerciseModel>,
    @StringRes screenTitle: Int,
    navController: NavController
) {
    onCanNavigateBackChange(true)
    onIsNavigationBarUpChange(false)

    var name by remember { mutableStateOf(NO_VALUE) }

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Scaffold(
        topBar = {
            TopBar(title = screenTitle, canNavigateBack = true) {
                navController.navigate(AddSessionRoutes.Start.name)
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
                                text = stringResource(R.string.session_name)
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
                    Divider(
                        Modifier
                            .fillMaxWidth()
                            .padding(start = 32.dp, end = 32.dp),
                        thickness = 1.dp,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }

                item {
                    AddExerciseCard(
                        navigateToAddExercises = navigateToAddExercises,
                        label = R.string.add_exercise
                    )
                }

                items(
                    items = temporaryList
                ) { item ->
                    Text(text = item.name)
                }

                if (isPressed) {
                    val copyList = temporaryList.map { it }.toMutableList()

                    temporaryList.forEach() {
                        it.isSelected = false
                    }

                    val session = SessionModel(0, name, exerciseList = copyList)
                    addSession(session)
                }
            }
        },
        floatingActionButton = {
            if (name != NO_VALUE) {
                FloatingActionButton(
                    onClick = navigateToMainSession,

                    interactionSource = interactionSource
                ) {
                    Icon(
                        Icons.Filled.Check,
                        contentDescription = "Create Session"
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.End
    )
}