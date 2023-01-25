package com.example.gymapp3_0.ui.screens.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import com.example.gymapp3_0.core.Constants.Companion.DELETE_SESSION

@Composable
fun DeleteIcon(
    deleteSession: () -> Unit
) {
    IconButton(
        onClick = deleteSession
    ) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = DELETE_SESSION,
        )
    }
}