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
            ViewExerciseSetsHeader(title = exercise.name)
        }

        items(
            items = sets
        ) { set ->

            val setCopy = SetModel(
                id = set.id,
                weight = set.weight,
                reps = set.reps,
                restTime = set.restTime,
                exerciseId = set.exerciseId
            )

            if (setCopy.exerciseId == exerciseId) {

                SetCard(
                    set = setCopy,
                    navigateToUpdateSetScreen = navigateToUpdateSetScreen,
                    deleteSet = {
                        deleteSet(setCopy)
                    }
                )
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
