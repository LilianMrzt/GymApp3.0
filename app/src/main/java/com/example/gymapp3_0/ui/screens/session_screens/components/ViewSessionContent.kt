package com.example.gymapp3_0.ui.screens.session_screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gymapp3_0.domain.models.SessionModel

@Composable
fun ViewSessionContent(
    padding: PaddingValues,
    session: SessionModel,
    navigateBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = session.name)

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(text = session.description)

        Button(
            onClick = {
                navigateBack()
            }
        ) {}
    }
}