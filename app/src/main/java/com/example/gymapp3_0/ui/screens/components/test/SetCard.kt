package com.example.gymapp3_0.ui.screens.components.test

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gymapp3_0.domain.models.SetModel
import com.example.gymapp3_0.ui.viewModels.SetsViewModel


@Composable
@ExperimentalMaterialApi
fun SetCard(
    set: SetModel,
    navigateToUpdateSetScreen: (setId: Int) -> Unit,
    setsViewModel: SetsViewModel = hiltViewModel()
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 4.dp,
                bottom = 4.dp
            )
            .fillMaxWidth(),
        elevation = 3.dp,
        onClick = {
            navigateToUpdateSetScreen(set.id)
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                Text(text = set.weight)
                Text(text = set.reps)
                Text(text = set.restTime)
            }
            Spacer(
                modifier = Modifier.weight(1f)
            )
            IconButton(
                onClick = {
                    setsViewModel.deleteSet(set)
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
        }
    }
}