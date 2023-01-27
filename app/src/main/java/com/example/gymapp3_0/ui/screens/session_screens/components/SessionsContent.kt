package com.example.gymapp3_0.ui.screens.session_screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.gymapp3_0.R
import com.example.gymapp3_0.domain.models.SessionModel
import com.example.gymapp3_0.domain.repository.Sessions

@Composable
@ExperimentalMaterialApi
fun SessionsContent(
    padding: PaddingValues,
    sessions: Sessions,
    deleteSession: (session: SessionModel) -> Unit,
    navigateToViewSession: (bookId: Int) -> Unit
) {
    if (sessions.isEmpty()) {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = stringResource(R.string.no_session_created))
        }
    } else {
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

                    navigateToViewSession = navigateToViewSession
                )
            }
        }
    }


}