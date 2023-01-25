package com.example.gymapp3_0.ui.screens.session_screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gymapp3_0.ui.viewModels.SessionViewModel

@Composable
fun ViewSessionBody(
    viewModel: SessionViewModel = hiltViewModel(),
    sessionId: Int,
    navigateBack: () -> Unit
) {
    Column() {
        Text(text = "Create Session")
    }
}