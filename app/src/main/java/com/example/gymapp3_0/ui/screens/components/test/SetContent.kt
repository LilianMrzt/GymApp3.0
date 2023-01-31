package com.example.gymapp3_0.ui.screens.components.test

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gymapp3_0.domain.repository.Sets
import com.example.gymapp3_0.ui.viewModels.SetsViewModel

@Composable
@ExperimentalMaterialApi
fun SetContent(
    padding: PaddingValues,
    sets: Sets,
    navigateToUpdateSetScreen: (setId: Int) -> Unit,
    setsViewModel: SetsViewModel = hiltViewModel(),
    navController: NavController,
    exerciseId: Int
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        items(
            items = sets
        ) { set ->
            if (set.exerciseId == exerciseId) {
                SetCard(
                    set = set,
                    navigateToUpdateSetScreen = navigateToUpdateSetScreen
                )
            }
        }
        item {
            Button(onClick = {
                //openDialog = true
                setsViewModel.openDialog()
            }) {
                Text(text = "Add Set")
            }
        }

        item {
            Button(onClick = {
                navController.navigateUp()
            }) {
                Text(text = "Back")
            }
        }
    }
}
