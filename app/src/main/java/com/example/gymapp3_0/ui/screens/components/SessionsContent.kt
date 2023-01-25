package com.example.gymapp3_0.ui.screens.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.gymapp.domain.models.SessionModel
import com.example.gymapp.domain.repository.Sessions

@Composable
@ExperimentalMaterialApi
fun SessionsContent(
    padding: PaddingValues,
    sessions: Sessions,
    deleteSession: (session: SessionModel) -> Unit,
    navigateToUpdateBookScreen: (bookId: Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        items(
            items = sessions
        ) { session ->
            SessionCard(
                session = session,
                deleteSession = {
                    deleteSession(session)
                },

                navigateToUpdateBookScreen = navigateToUpdateBookScreen
            )
        }
    }
}