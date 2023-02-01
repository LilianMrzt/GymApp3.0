package com.example.gymapp3_0.ui.screens.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.gymapp3_0.R
import com.example.gymapp3_0.domain.models.ExerciseModel
import com.example.gymapp3_0.domain.models.SetModel
import com.example.gymapp3_0.domain.repository.Sets
import com.example.gymapp3_0.ui.viewModels.SetsViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SetContent(
    padding: PaddingValues,
    sets: Sets,
    navigateToUpdateSetScreen: (setId: Int) -> Unit,
    setsViewModel: SetsViewModel = hiltViewModel(),
    navController: NavController,
    exerciseId: Int,
    exercise: ExerciseModel,
    deleteSet: (set: SetModel) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        stickyHeader {
            BasicHeader(title = R.string.exercise)
        }

        items(
            items = sets
        ) { set ->
            if (set.exerciseId == exerciseId) {
                SetCard(
                    set = set,
                    navigateToUpdateSetScreen = navigateToUpdateSetScreen,
                    deleteSet = {
                        deleteSet(set)
                    }
                )
            }
        }

        item {
            Button(onClick = {
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
