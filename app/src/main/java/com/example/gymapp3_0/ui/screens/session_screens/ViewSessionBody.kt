package com.example.gymapp3_0.ui.screens.session_screens

import androidx.annotation.StringRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gymapp3_0.R
import com.example.gymapp3_0.ui.navigation.AddSessionRoutes
import com.example.gymapp3_0.ui.screens.components.BasicHeader
import com.example.gymapp3_0.ui.screens.components.ExerciseCardForSessionView
import com.example.gymapp3_0.ui.screens.components.TopBar
import com.example.gymapp3_0.ui.viewModels.SessionViewModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun ViewSessionBody(
    sessionViewModel: SessionViewModel = hiltViewModel(),
    sessionId: Int,
    @StringRes screenTitle: Int,
    navController: NavController,
    navigateToViewExerciseContent: (exerciseId: Int) -> Unit,
) {
    LaunchedEffect(Unit) {
        sessionViewModel.getSession(sessionId)
    }
    Scaffold(
        topBar = {
            TopBar(canNavigateBack = true) {
                navController.navigate(AddSessionRoutes.Start.name)
            }
        },
        content = { paddingValues ->
            LazyColumn(
                state = rememberLazyListState(),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                stickyHeader {
                    BasicHeader(title = R.string.select_exercise)
                }

                items(
                    items = sessionViewModel.session.exerciseList
                ) { item ->
                    ExerciseCardForSessionView(
                        exercise = item,
                        navigateToViewExerciseContent = navigateToViewExerciseContent
                    )
                }
            }
        }
    )
}