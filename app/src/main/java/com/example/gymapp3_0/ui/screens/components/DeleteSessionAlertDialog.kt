package com.example.gymapp3_0.ui.screens.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.gymapp3_0.R

@Composable
fun DeleteSessionAlertDialog(
    deleteSession: () -> Unit,
) {

    var deleteClicked by remember { mutableStateOf(false) }
    var expanded by remember { mutableStateOf(false) }

    IconButton(
        onClick = {
            expanded = true
        },
        modifier = Modifier
            .size(30.dp)
            .padding(0.dp)
    ) {
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "",
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .background(MaterialTheme.colorScheme.surfaceVariant),

            ) {

            DropdownMenuItem(
                onClick = {
                    deleteClicked = true
                    expanded = false
                },
                text = { Text(text = "Delete") },
                trailingIcon = {
                    Icon(
                        Icons.Outlined.Delete,
                        contentDescription = null
                    )
                }
            )
        }
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
                        deleteSession()
                        deleteClicked = false
                    },
                ) {
                    Text(stringResource(R.string.delete))
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