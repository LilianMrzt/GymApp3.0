package com.example.gymapp3_0.ui.screens.components

import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.example.gymapp3_0.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    canNavigateBack: Boolean,
    navigateBack: () -> Unit,
    navigateToSettings: () -> Unit
) {

    var expanded by remember { mutableStateOf(false) }
    val context = LocalContext.current
    var iconSize by remember { mutableStateOf(Size.Zero) }

    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "",
            )
        },
        actions = {
            IconButton(
                onClick = { expanded = !expanded },
            ) {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "Localized description",

                    )
            }
            // Creating a dropdown menu
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {

                // Creating dropdown menu item, on click
                // would create a Toast message
                DropdownMenuItem(
                    text = { Text("Settings") },
                    onClick = {
                        navigateToSettings()
                    },
                    trailingIcon = {
                        Icon(
                            Icons.Outlined.Settings,
                            contentDescription = null
                        )
                    },
                )

                // Creating dropdown menu item, on click
                // would create a Toast message
                DropdownMenuItem(
                    text = { Text("Logout") },
                    onClick = {
                        Toast.makeText(context, "Logout", Toast.LENGTH_SHORT).show()
                    },
                    trailingIcon = {
                        Icon(
                            Icons.Filled.Logout,
                            contentDescription = null
                        )
                    },
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateBack) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}