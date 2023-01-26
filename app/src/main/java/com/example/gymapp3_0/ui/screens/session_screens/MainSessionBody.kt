package com.example.gymapp3_0.ui.screens.session_screens

import android.annotation.SuppressLint
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gymapp3_0.ui.screens.session_screens.components.SessionsContent
import com.example.gymapp3_0.ui.viewModels.SessionViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SessionsMainBody(
    viewModel: SessionViewModel = hiltViewModel(),
    navigateToCreateSession: () -> Unit,
    navigateToViewSession: (sessionID: Int) -> Unit,
) {

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
                navigateToViewSession = navigateToViewSession //navigateToViewSession
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
                onClick = navigateToCreateSession,
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Add Session")
            }
        },
    )


}