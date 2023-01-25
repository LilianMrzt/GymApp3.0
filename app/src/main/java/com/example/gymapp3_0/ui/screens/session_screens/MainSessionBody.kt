package com.example.gymapp3_0.ui.screens.session_screens

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SessionsMainBody(
    //viewModel: SessionViewModel = hiltViewModel(),
    //navigateToCreateSession: () -> Unit,
    //navigateToViewSession: (sessionID: Int) -> Unit,
) {
/*
    val sessions by viewModel.sessions.collectAsState(
        initial = emptyList()
    )

    Scaffold(
        content = { padding ->
            SessionsContent(
                padding = padding,
                sessions = sessions,
                deleteSession = { session ->
                    viewModel.deleteSession(session)
                },
                navigateToUpdateBookScreen = navigateToViewSession
            )

            /*
            AddBookAlertDialog(
                openDialog = viewModel.openDialog,
                closeDialog = {
                    viewModel.closeDialog()
                },
                addBook = { book ->
                    viewModel.addBook(book)
                }
            )

             */
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {}//navigateToCreateSession,
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Add Session")
            }
        },
    )

 */
}