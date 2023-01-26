package com.example.gymapp3_0.ui.screens.session_screens.components

import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun TextName(
    sessionName: String
) {
    Text(
        text = sessionName,
        color = Color.DarkGray,
        fontSize = 25.sp,
        style = MaterialTheme.typography.titleLarge
    )
}