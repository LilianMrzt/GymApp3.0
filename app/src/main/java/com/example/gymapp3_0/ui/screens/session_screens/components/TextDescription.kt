package com.example.gymapp3_0.ui.screens.session_screens.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp


@Composable
fun TextDescription(
    sessionDescription: String
) {
    Text(
        text = sessionDescription,
        color = Color.DarkGray,
        fontSize = 12.sp,
    )
}