package com.example.gymapp3_0.ui.screens.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.gymapp3_0.R


//TOP BAR OK
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    canNavigateBack: Boolean,
    navigateBack: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "",
            )
        },
        actions = {
            IconButton(onClick = { /* doSomething() */ }) {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "Localized description"
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