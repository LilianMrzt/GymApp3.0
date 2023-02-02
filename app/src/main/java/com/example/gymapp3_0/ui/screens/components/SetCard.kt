package com.example.gymapp3_0.ui.screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gymapp3_0.R
import com.example.gymapp3_0.domain.models.SetModel
import com.example.gymapp3_0.ui.viewModels.SetsViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetCard(
    set: SetModel,
    navigateToUpdateSetScreen: (setId: Int) -> Unit,
    setsViewModel: SetsViewModel = hiltViewModel(),
    deleteSet: () -> Unit,
) {
    ElevatedCard(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 10.dp,
                bottom = 5.dp
            )
            .fillMaxWidth(),
        onClick = {
            navigateToUpdateSetScreen(set.id)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 8.dp,
                    end = 8.dp,
                    top = 16.dp,
                    bottom = 16.dp
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                SetInfoCard(
                    title = R.string.weight,
                    content = "${set.weight} kg"
                )

                SetInfoCard(
                    title = R.string.reps,
                    content = set.reps
                )

                SetInfoCard(
                    title = R.string.rest_time,
                    content = "${set.restTime} min"
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            IconButton(
                onClick = {
                    setsViewModel.openDialogForModification()
                },
                modifier = Modifier
                    .size(30.dp)
                    .padding(0.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "",
                )
            }
            DeleteSetAlertDialog(
                openDialogForModification = setsViewModel.openDialogForModification,
                closeDialogForModification = { setsViewModel.closeDialogForModification() },
                deleteSet = deleteSet
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SetCardPreview() {
    SetCard(
        set = SetModel(id = 1, weight = "14", reps = "8", restTime = "1", exerciseId = 1),
        navigateToUpdateSetScreen = {},
        deleteSet = {}
    )
}