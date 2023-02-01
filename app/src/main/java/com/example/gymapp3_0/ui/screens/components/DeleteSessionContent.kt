package com.example.gymapp3_0.ui.screens.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gymapp3_0.R
import com.example.gymapp3_0.domain.models.SessionModel
import com.example.gymapp3_0.ui.viewModels.SessionViewModel

@Composable
fun DeleteSessionContent(
    sessionViewModel: SessionViewModel = hiltViewModel(),
    session: SessionModel,
) {

    var deleteClicked by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    IconButton(
        onClick = {
            deleteClicked = true
        },
        modifier = Modifier
            .size(30.dp)
            .padding(0.dp)
    ) {
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "",
        )
    }

    if (deleteClicked) {
        AlertDialog(
            onDismissRequest = {
                deleteClicked = false
            },
            title = {
                Text(text = stringResource(R.string.warning))
            },
            text = {
                Text(text = stringResource(R.string.delete_session_confirmation))
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        deleteClicked = false
                    },
                    interactionSource = interactionSource
                ) {
                    Text(stringResource(R.string.delete))
                    if (isPressed) {
                        sessionViewModel.deleteSession(session)
                    }
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        deleteClicked = false
                    }
                ) {
                    Text(stringResource(R.string.cancel))
                }
            }
        )
    }
}