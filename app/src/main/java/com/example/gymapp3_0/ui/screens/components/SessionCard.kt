package com.example.gymapp3_0.ui.screens.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gymapp3_0.domain.models.SessionModel

@Composable
@ExperimentalMaterial3Api
fun SessionCard(
    session: SessionModel,
    deleteSession: () -> Unit,
    navigateToUpdateBookScreen: (bookId: Int) -> Unit
) {
    ElevatedCard(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 4.dp,
                bottom = 4.dp
            )
            .fillMaxWidth()
            .clickable { navigateToUpdateBookScreen(session.id) },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                TextName(
                    sessionName = session.name
                )
                TextDescription(
                    sessionDescription = session.description
                )
            }
            Spacer(
                modifier = Modifier.weight(1f)
            )
            DeleteIcon(
                deleteSession = deleteSession
            )
        }
    }
}