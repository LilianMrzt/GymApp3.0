package com.example.gymapp3_0.ui.screens.session_screens.components

import android.annotation.SuppressLint
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gymapp3_0.domain.models.ExerciseModel
import com.example.gymapp3_0.ui.viewModels.ExerciseViewModel

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExerciseCard(
    exercise: ExerciseModel,
    deleteExercise: () -> Unit,
    ExerciseViewModel: ExerciseViewModel = hiltViewModel()
) {
    //val isSelected = rememberSaveable { mutableStateOf(exercise.isSelected) }
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 5.dp, bottom = 5.dp),
        shape = RoundedCornerShape(10.dp),
        onClick = {
            //isSelected.value != isSelected.value
            //exercise.isSelected = isSelected.value
            ExerciseViewModel.updateExercise(exercise)
            /*
            if (!exercise.isSelected) {
                viewModel.toggle(true)
            } else {
                viewModel.toggle(false)
            }

             */
        },
        interactionSource = interactionSource
    ) {
        Row(
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp,
                top = 10.dp,
                bottom = 10.dp
            ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
            ) {

                Text(
                    modifier = Modifier,
                    text = exercise.name,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    modifier = Modifier,
                    text = exercise.muscle
                )
            }


            Spacer(modifier = Modifier.weight(1f))

            DeleteIcon(
                deleteSession = deleteExercise
            )

        }
    }
}