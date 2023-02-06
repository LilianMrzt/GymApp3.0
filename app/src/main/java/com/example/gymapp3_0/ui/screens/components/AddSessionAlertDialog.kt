package com.example.gymapp3_0.ui.screens.components

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.gymapp3_0.R
import com.example.gymapp3_0.core.Constants
import com.example.gymapp3_0.core.Constants.Companion.NO_VALUE
import com.example.gymapp3_0.domain.models.SessionModel
import kotlinx.coroutines.job

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddSessionAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addSession: (session: SessionModel) -> Unit,
) {
    if (openDialog) {
        var name by remember { mutableStateOf(NO_VALUE) }
        val focusRequester = FocusRequester()
        val context = LocalContext.current

        AlertDialog(
            onDismissRequest = closeDialog,
            title = {
                Text(text = stringResource(R.string.add_session))
            },
            text = {
                Column {
                    TextField(
                        value = name,
                        onValueChange = { name = it },
                        placeholder = {
                            Text(
                                text = stringResource(id = R.string.session_name),
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        },
                        modifier = Modifier.focusRequester(focusRequester),
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            focusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                        ),
                        textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
                        shape = RoundedCornerShape(Constants.ROUNDED_CORNER)
                    )

                    LaunchedEffect(Unit) {
                        coroutineContext.job.invokeOnCompletion {
                            focusRequester.requestFocus()
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        if (name != NO_VALUE) {
                            addSession(
                                SessionModel(
                                    id = 0,
                                    name = name,
                                    exerciseList = mutableListOf()
                                )
                            )
                            closeDialog()
                        } else {
                            Toast.makeText(context, "Please complete everything", Toast.LENGTH_LONG)
                                .show()
                        }
                    },
                ) {
                    Text(stringResource(R.string.add))
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialog
                ) {
                    Text(stringResource(R.string.cancel))
                }
            }
        )
    }
}
