package com.example.gymapp3_0.ui.screens.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gymapp3_0.ui.viewModels.SessionViewModel

@Composable
fun ViewSessionContent(
    selectedSessionID: Int,
    navigateBack: () -> Unit,
    sessionViewModel: SessionViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        sessionViewModel.getSession(selectedSessionID)
    }
    LazyColumn(
        state = rememberLazyListState(),
        modifier = Modifier.fillMaxSize()
    ) {
        items(
            items = sessionViewModel.session.exerciseList
        ) { item ->
            //item.id = sessionList[selectedSessionID].exercises.indexOf(item)
            item.name
        }

        item {
            Button(
                onClick = {
                    navigateBack()
                }
            ) {}
        }
    }
}