package com.example.gymapp3_0.ui.screens.session_screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gymapp3_0.ui.screens.components.ViewSessionContent
import com.example.gymapp3_0.ui.viewModels.SessionViewModel

@Composable
fun ViewSessionBody(
    viewModel: SessionViewModel = hiltViewModel(),
    sessionId: Int,
    navigateBack: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.getSession(sessionId)
    }
    Scaffold(
        content = { padding ->
            ViewSessionContent(
                padding = padding,
                session = viewModel.session,
                navigateBack = navigateBack
            )
        }
    )
}