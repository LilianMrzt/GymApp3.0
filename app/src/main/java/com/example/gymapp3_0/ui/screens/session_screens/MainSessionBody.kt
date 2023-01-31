package com.example.gymapp3_0.ui.screens.session_screens

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gymapp3_0.domain.models.ExerciseModel
import com.example.gymapp3_0.ui.screens.components.SessionsContent
import com.example.gymapp3_0.ui.screens.components.TopBar
import com.example.gymapp3_0.ui.viewModels.ExerciseViewModel
import com.example.gymapp3_0.ui.viewModels.SessionViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SessionsMainBody(
    sessionViewModel: SessionViewModel = hiltViewModel(),
    exerciseViewModel: ExerciseViewModel = hiltViewModel(),
    navigateToCreateSession: () -> Unit,
    navigateToViewSession: (sessionID: Int) -> Unit,
    temporaryList: MutableList<ExerciseModel>,
    @StringRes screenTitle: Int,
) {

    val sessions by sessionViewModel.sessions.collectAsState(
        initial = emptyList()
    )

    val exercises by exerciseViewModel.exercises.collectAsState(
        initial = emptyList()
    )

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Scaffold(
        topBar = {
            TopBar(canNavigateBack = false) { }
        },
        content = { padding ->
            SessionsContent(
                padding = padding,
                sessions = sessions,
                deleteSession = { session ->
                    sessionViewModel.deleteSession(session)
                },
                navigateToViewSession = navigateToViewSession //navigateToViewSession
            )

            if (isPressed) {
                temporaryList.clear()
                exercises.forEach() { item ->
                    item.isSelected = false
                    exerciseViewModel.updateExercise(item)
                }
            }
        },


        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToCreateSession,
                interactionSource = interactionSource
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Add Session")
            }
        },
    )
}