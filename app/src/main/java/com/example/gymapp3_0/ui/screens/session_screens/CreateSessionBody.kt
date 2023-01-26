package com.example.gymapp3_0.ui.screens.session_screens

import android.annotation.SuppressLint
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.gymapp3_0.core.Constants.Companion.DESCRIPTION
import com.example.gymapp3_0.core.Constants.Companion.NO_VALUE
import com.example.gymapp3_0.core.Constants.Companion.SESSION_NAME
import com.example.gymapp3_0.domain.models.SessionModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
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

    Scaffold(
        floatingActionButton = {
            if (name != NO_VALUE && description != NO_VALUE) {
                FloatingActionButton(
                    onClick = navigateToMainSession,

                    interactionSource = interactionSource
                ) {
                    Icon(
                        Icons.Filled.Check,
                        contentDescription = "Add Session"
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        Column() {
            TextField(
                value = name,
                onValueChange = { name = it },
                placeholder = {
                    Text(
                        text = SESSION_NAME
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                singleLine = true,
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = MaterialTheme.colorScheme.onPrimary,
                    disabledTextColor = MaterialTheme.colorScheme.secondary,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )

            Spacer(
                modifier = Modifier.height(5.dp)
            )

            TextField(
                value = description,
                onValueChange = { description = it },
                placeholder = {
                    Text(
                        text = DESCRIPTION
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                singleLine = true,
                shape = RoundedCornerShape(10.dp),
                colors = TextFieldDefaults.textFieldColors(
                    textColor = MaterialTheme.colorScheme.onPrimary,
                    disabledTextColor = MaterialTheme.colorScheme.secondary,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )

            if (isPressed) {
                val session = SessionModel(0, name, description)
                addSession(session)
            }
        }


    }
}