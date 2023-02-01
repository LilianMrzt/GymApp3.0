package com.example.gymapp3_0.ui.screens.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.gymapp3_0.R

@Composable
fun DeleteSetAlertDialog(
    openDialogForModification: Boolean,
    closeDialogForModification: () -> Unit,
    deleteSet: () -> Unit,
) {
    if (openDialogForModification) {
        AlertDialog(
            onDismissRequest = closeDialogForModification,
            title = {
                Text(text = stringResource(R.string.warning))
            },
            text = {
                Text(text = stringResource(R.string.delete_set_confirmation))
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        deleteSet()
                        closeDialogForModification()
                    },
                ) {
                    Text(stringResource(R.string.delete))
                }
            },
            dismissButton = {
                TextButton(
                    onClick = closeDialogForModification
                ) {
                    Text(stringResource(R.string.cancel))
                }
            }
        )
    }
}
