package com.example.gymapp3_0.ui.screens.components

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.gymapp3_0.R
import com.example.gymapp3_0.core.Constants
import com.example.gymapp3_0.core.Constants.Companion.NO_VALUE
import com.example.gymapp3_0.domain.models.SessionColor
import com.example.gymapp3_0.domain.models.SessionModel
import com.example.gymapp3_0.domain.models.toColor
import kotlinx.coroutines.job

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddSessionAlertDialog(
    openDialog: Boolean,
    closeDialog: () -> Unit,
    addSession: (session: SessionModel) -> Unit,
) {
    if (openDialog) {
        var name by remember { mutableStateOf(NO_VALUE) }
        var color by remember { mutableStateOf(SessionColor.BLUE) }
        val focusRequester = FocusRequester()
        val context = LocalContext.current

        var isBlueSelected = remember { mutableStateOf(true) }
        var isGreenSelected = remember { mutableStateOf(false) }
        var isRedSelected = remember { mutableStateOf(false) }
        var isOrangeSelected = remember { mutableStateOf(false) }
        var isBlackSelected = remember { mutableStateOf(false) }
        var isPurpleSelected = remember { mutableStateOf(false) }
        var isYellowSelected = remember { mutableStateOf(false) }
        var isBrownSelected = remember { mutableStateOf(false) }

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

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Button(
                            onClick = {
                                color = SessionColor.BLUE
                                isBlueSelected.value = true
                                isGreenSelected.value = false
                                isOrangeSelected.value = false
                                isRedSelected.value = false
                                isBlackSelected.value = false
                                isBrownSelected.value = false
                                isYellowSelected.value = false
                                isPurpleSelected.value = false
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = SessionColor.BLUE.toColor()
                            ),
                            shape = CircleShape,
                            modifier = Modifier.size(40.dp),
                            contentPadding = PaddingValues(0.dp),
                        ) {
                            if (isBlueSelected.value) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "",
                                    tint = MaterialTheme.colorScheme.onSurface,
                                )
                            }
                        }

                        Button(
                            onClick = {
                                color = SessionColor.GREEN
                                isBlueSelected.value = false
                                isGreenSelected.value = true
                                isOrangeSelected.value = false
                                isRedSelected.value = false
                                isBlackSelected.value = false
                                isBrownSelected.value = false
                                isYellowSelected.value = false
                                isPurpleSelected.value = false
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = SessionColor.GREEN.toColor()
                            ),
                            shape = CircleShape,
                            modifier = Modifier.size(40.dp),
                            contentPadding = PaddingValues(0.dp),
                        ) {
                            if (isGreenSelected.value) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "",
                                    tint = MaterialTheme.colorScheme.onSurface,
                                )
                            }
                        }

                        Button(
                            onClick = {
                                color = SessionColor.RED
                                isBlueSelected.value = false
                                isGreenSelected.value = false
                                isOrangeSelected.value = false
                                isRedSelected.value = true
                                isBlackSelected.value = false
                                isBrownSelected.value = false
                                isYellowSelected.value = false
                                isPurpleSelected.value = false
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = SessionColor.RED.toColor()
                            ),
                            shape = CircleShape,
                            modifier = Modifier.size(40.dp),
                            contentPadding = PaddingValues(0.dp),
                        ) {
                            if (isRedSelected.value) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "",
                                    tint = MaterialTheme.colorScheme.onSurface,
                                )
                            }
                        }

                        Button(
                            onClick = {
                                color = SessionColor.ORANGE
                                isBlueSelected.value = false
                                isGreenSelected.value = false
                                isOrangeSelected.value = true
                                isRedSelected.value = false
                                isBlackSelected.value = false
                                isBrownSelected.value = false
                                isYellowSelected.value = false
                                isPurpleSelected.value = false
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = SessionColor.ORANGE.toColor()
                            ),
                            shape = CircleShape,
                            modifier = Modifier.size(40.dp),
                            contentPadding = PaddingValues(0.dp),
                        ) {
                            if (isOrangeSelected.value) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "",
                                    tint = MaterialTheme.colorScheme.onSurface,
                                )
                            }
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Button(
                            onClick = {
                                color = SessionColor.BLACK
                                isBlueSelected.value = false
                                isGreenSelected.value = false
                                isOrangeSelected.value = false
                                isRedSelected.value = false
                                isBlackSelected.value = true
                                isBrownSelected.value = false
                                isYellowSelected.value = false
                                isPurpleSelected.value = false

                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = SessionColor.BLACK.toColor()
                            ),
                            shape = CircleShape,
                            modifier = Modifier.size(40.dp),
                            contentPadding = PaddingValues(0.dp),
                        ) {
                            if (isBlackSelected.value) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "",
                                    tint = MaterialTheme.colorScheme.onSurface,
                                )
                            }
                        }

                        Button(
                            onClick = {
                                color = SessionColor.PURPLE
                                isBlueSelected.value = false
                                isGreenSelected.value = false
                                isOrangeSelected.value = false
                                isRedSelected.value = false
                                isBlackSelected.value = false
                                isBrownSelected.value = false
                                isYellowSelected.value = false
                                isPurpleSelected.value = true
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = SessionColor.PURPLE.toColor()
                            ),
                            shape = CircleShape,
                            modifier = Modifier.size(40.dp),
                            contentPadding = PaddingValues(0.dp),
                        ) {
                            if (isPurpleSelected.value) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "",
                                    tint = MaterialTheme.colorScheme.onSurface,
                                )
                            }
                        }

                        Button(
                            onClick = {
                                color = SessionColor.BROWN
                                isBlueSelected.value = false
                                isGreenSelected.value = false
                                isOrangeSelected.value = false
                                isRedSelected.value = false
                                isBlackSelected.value = false
                                isBrownSelected.value = true
                                isYellowSelected.value = false
                                isPurpleSelected.value = false
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = SessionColor.BROWN.toColor()
                            ),
                            shape = CircleShape,
                            modifier = Modifier.size(40.dp),
                            contentPadding = PaddingValues(0.dp),
                        ) {
                            if (isBrownSelected.value) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "",
                                    tint = MaterialTheme.colorScheme.onSurface,
                                )
                            }
                        }

                        Button(
                            onClick = {
                                color = SessionColor.YELLOW
                                isBlueSelected.value = false
                                isGreenSelected.value = false
                                isOrangeSelected.value = false
                                isRedSelected.value = false
                                isBlackSelected.value = false
                                isBrownSelected.value = false
                                isYellowSelected.value = true
                                isPurpleSelected.value = false
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = SessionColor.YELLOW.toColor()
                            ),
                            shape = CircleShape,
                            modifier = Modifier.size(40.dp),
                            contentPadding = PaddingValues(0.dp),
                        ) {
                            if (isYellowSelected.value) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "",
                                    tint = MaterialTheme.colorScheme.onSurface,
                                )
                            }
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
                                    exerciseList = mutableListOf(),
                                    sessionColor = color
                                )
                            )
                            closeDialog()
                        } else {
                            Toast.makeText(
                                context,
                                R.string.complete_every_field,
                                Toast.LENGTH_LONG
                            )
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
