package com.example.gymapp3_0.ui.screens.session_screens

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gymapp3_0.core.Constants.Companion.DESCRIPTION
import com.example.gymapp3_0.core.Constants.Companion.NO_VALUE
import com.example.gymapp3_0.core.Constants.Companion.SESSION_NAME
import com.example.gymapp3_0.domain.models.SessionModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateSessionBody(
    modifier: Modifier,
    addSession: (book: SessionModel) -> Unit,
    navigateToMainSession: () -> Unit,
) {

    var name by remember { mutableStateOf(NO_VALUE) }
    var description by remember { mutableStateOf(NO_VALUE) }

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Column {
        TextField(
            value = name,
            onValueChange = { name = it },
            placeholder = {
                Text(
                    text = SESSION_NAME
                )
            },
            modifier = Modifier
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        TextField(
            value = description,
            onValueChange = { description = it },
            placeholder = {
                Text(
                    text = DESCRIPTION
                )
            }
        )

        Button(
            onClick = navigateToMainSession,
            interactionSource = interactionSource
        ) {
            if (isPressed) {
                val session = SessionModel(0, name, description)
                addSession(session)
            }

        }

    }
}