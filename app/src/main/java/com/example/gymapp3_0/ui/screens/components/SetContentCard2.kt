package com.example.gymapp3_0.ui.screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.gymapp3_0.domain.models.SetModel
import com.example.gymapp3_0.ui.viewModels.SetsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetContentCard2(
    set: SetModel,
    updateWeight: (weight: String) -> Unit,
    updateReps: (reps: String) -> Unit,
    updateRestTime: (rest: String) -> Unit,
    updateSet: (set: SetModel) -> Unit,
    setsViewModel: SetsViewModel = hiltViewModel()
) {
    
    ElevatedCard(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 10.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = set.weight,
                onValueChange = { weight ->
                    updateWeight(weight)
                },
                placeholder = {
                    Text(
                        text = "BOOK_TITLE"
                    )
                }
            )
            Spacer(
                modifier = Modifier.height(8.dp)
            )


            TextField(
                value = set.reps,
                onValueChange = { reps ->
                    updateReps(reps)
                },
                placeholder = {
                    Text(
                        text = "BOOK_TITLE"
                    )
                }
            )
            Spacer(
                modifier = Modifier.height(8.dp)
            )


            TextField(
                value = set.restTime,
                onValueChange = { restTime ->
                    updateRestTime(restTime)
                },
                placeholder = {
                    Text(
                        text = "BOOK_TITLE"
                    )
                }
            )
            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                IconButton(
                    onClick = {
                        updateSet(set)
                    },
                    modifier = Modifier
                        .size(30.dp)
                        .padding(0.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "",
                    )
                }

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
}


