package com.example.gymapp3_0.ui.screens.session_screens

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.gymapp3_0.R
import com.example.gymapp3_0.ui.screens.components.BasicHeader
import com.example.gymapp3_0.ui.screens.components.TopBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun Settings(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopBar(
                canNavigateBack = true,
                navigateBack = {
                    navController.navigateUp()
                },
                navigateToSettings = { }
            )
        },
        content = { padding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                stickyHeader {
                    BasicHeader(R.string.settings)
                }
            }
        }
    )
}