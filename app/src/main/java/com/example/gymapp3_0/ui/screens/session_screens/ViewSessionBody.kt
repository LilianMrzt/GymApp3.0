package com.example.gymapp3_0.ui.screens.session_screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gymapp3_0.ui.screens.components.ExerciseCardForSessionView
import com.example.gymapp3_0.ui.viewModels.SessionViewModel

@Composable
fun ViewSessionBody(
    sessionViewModel: SessionViewModel = hiltViewModel(),
    sessionId: Int,
    navigateBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        sessionViewModel.getSession(sessionId)
    }
    LazyColumn(
        state = rememberLazyListState(),
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text(text = sessionViewModel.session.name)
        }

        items(
            items = sessionViewModel.session.exerciseList
        ) { item ->
            //item.id = sessionList[selectedSessionID].exercises.indexOf(item)
            ExerciseCardForSessionView(item)
        }
    }

}