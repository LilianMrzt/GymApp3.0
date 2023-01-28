package com.example.gymapp3_0.ui.screens.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gymapp3_0.core.Constants.Companion.DELETE_SESSION

@Composable
fun DeleteIcon(
    deleteSession: () -> Unit
) {
    IconButton(
        onClick = deleteSession,
        modifier = Modifier
            .size(30.dp)
            .padding(0.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = DELETE_SESSION,

            )
    }
}